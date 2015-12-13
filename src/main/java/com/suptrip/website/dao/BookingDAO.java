package com.suptrip.website.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.suptrip.website.database.PersistanceManager;
import com.suptrip.website.entity.Booking;
import com.suptrip.website.entity.Campus;

public class BookingDAO {
	public static List<Booking> getBookingsFromId(int id){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT b FROM Booking b WHERE b.user.booster_id ='"+id+"'  ORDER BY b.trip_booked.tripDate ASC");
        return (List<Booking>)query.getResultList();
	}
	
	public static void addBooking(Booking booking){
		EntityManager em = PersistanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(booking);
		et.commit();
		em.close();
	}
}
