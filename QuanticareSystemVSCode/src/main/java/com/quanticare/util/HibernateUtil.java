package com.quanticare.util;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("quanticarePU");
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
