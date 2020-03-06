package main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("java2c2PU");

        EntityManager em = emf.createEntityManager();

        Angajat a = em.find(Angajat.class, 1);

        System.out.println(a);

        try {
            em.getTransaction().begin();

            a.setNume("Marian");

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }


    }
}
