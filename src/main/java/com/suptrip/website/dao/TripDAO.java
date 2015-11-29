package com.suptrip.website.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
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
}
