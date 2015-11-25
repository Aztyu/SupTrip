package com.suptrip.website.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.suptrip.website.database.PersistanceManager;
import com.suptrip.website.entity.Campus;
import com.suptrip.website.entity.User;

public class UserDAO {
	public static User getUser(int booster_id, String password){
        EntityManager em = PersistanceManager.getEntityManager();
        Query query = em.createQuery("SELECT user FROM User as user WHERE user.id_booster = :id AND user.password = :password");
        query.setParameter("id", booster_id);
        query.setParameter("password", password);

        User user = (User) query.getSingleResult();
        
        em.close();
        return user;
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
