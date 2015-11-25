package com.suptrip.website.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistanceManager {
    private static EntityManagerFactory emf;

    private PersistanceManager(){}

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("SupTripPU");
        }
        return emf;
    }

    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }	
}
