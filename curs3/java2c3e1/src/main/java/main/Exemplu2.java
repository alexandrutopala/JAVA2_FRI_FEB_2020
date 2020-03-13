package main;

import db.Produs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3PU");
        EntityManager em = emf.createEntityManager();

        Produs p = em.find(Produs.class, 3);

        System.out.println(p);
    }
}
