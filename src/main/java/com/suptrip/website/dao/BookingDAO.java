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
        Query query = em.createQuery("SELECT b FROM Booking b WHERE b.user.booster_id ='"+id+"'");
        return (List<Booking>)query.getResultList();
	}
}
