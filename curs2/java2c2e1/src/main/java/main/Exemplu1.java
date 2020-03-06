package main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("java2c2PU");

        EntityManager em = emf.createEntityManager();

        Angajat a = new Angajat();

        a.setNume("costel");
        a.setVarsta(24);

        try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
