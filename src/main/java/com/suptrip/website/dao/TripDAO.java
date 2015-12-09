package com.suptrip.website.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.suptrip.website.database.PersistanceManager;
import com.suptrip.website.entity.Trip;

public class TripDAO {
	@SuppressWarnings("unchecked")
	public static List<Trip> getAllTrips(){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT t FROM Trip t");
        return (List<Trip>)query.getResultList();
	}
	
	public static List<Trip> getTripsByCampusId(int campus_id){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT t FROM Trip t WHERE (t.start.id ="+campus_id+" OR t.destination.id ="+campus_id+") AND t.tripDate > '" + sdf.format(now) + "' ORDER BY t.tripDate ASC");
        List<Trip> trips = (List<Trip>)query.getResultList();
        for (Trip t : trips) {
			t.updateDuration();
		}
        return (List<Trip>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Trip> getAllAvailableTrips(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT t FROM Trip t WHERE t.tripDate > '" + sdf.format(now) + "' ORDER BY t.tripDate ASC");
        List<Trip> trips = (List<Trip>)query.getResultList();
        for (Trip t : trips) {
			t.updateDuration();
		}
        return trips;
	}
	
	public static long tripNumber(){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT COUNT(t.id) FROM Trip t");
        return (Long)query.getSingleResult();
	}

	public static void addTrip(Trip trip) {
		EntityManager em = PersistanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(trip);
		et.commit();
		em.close();
	}
}
