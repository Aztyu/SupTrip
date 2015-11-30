package com.suptrip.website.dao;

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
        Query query = em.createQuery("SELECT c FROM Campus c");
        return (List<Trip>)query.getResultList();
	}
	
	public static long tripNumber(){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT COUNT(c.id) FROM Trip c");
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
