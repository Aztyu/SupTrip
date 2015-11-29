package com.suptrip.website.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.suptrip.website.database.PersistanceManager;
import com.suptrip.website.entity.Campus;

public class CampusDAO {
	public static Campus getCampusFromId(int id){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Campus c WHERE c.id ='"+id+"'");
        if(query.getResultList().isEmpty()){
            return null;
        }else{
            return (Campus)query.getSingleResult();
        }
	}
	
	@SuppressWarnings("unchecked")
	public static List<Campus> getAllCampus(){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Campus c");
        if(query.getResultList().isEmpty()){
            return Collections.emptyList();
        }else{
            return (List<Campus>)query.getResultList();
        }
	}
	
	public static void addCampus(Campus campus){
		EntityManager em = PersistanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(campus);
		et.commit();
		em.close();
	}
}
