package com.suptrip.website.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.suptrip.website.database.PersistanceManager;
import com.suptrip.website.entity.User;

public class UserDAO {
	public static User getUser(int booster_id, String password){
        EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT user FROM User as user WHERE user.booster_id = :id AND user.password = :password");
        query.setParameter("id", booster_id);
        query.setParameter("password", password);
        if(query.getResultList().isEmpty()){
            return null;
        }else{
            return (User)query.getSingleResult();
        }
    }
	
	public static boolean userExists(int booster_id){
        EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT user FROM User as user WHERE user.booster_id = :id");
        query.setParameter("id", booster_id);
        return !query.getResultList().isEmpty();
    }
	
	public static void addUser(User user){
		EntityManager em = PersistanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
		em.close();
	}
	
	public static long userNumber(){
		EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT COUNT(u.booster_id) FROM User u");
        return (Long)query.getSingleResult();
	}
	
	public static void updateUser(User u){
		EntityManager em = PersistanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(u);
		et.commit();
		em.close();
	}
}
