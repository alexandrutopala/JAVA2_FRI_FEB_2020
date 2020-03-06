package main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu4 {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("java2c2PU");

        EntityManager em = emf.createEntityManager();

        Angajat angajat = em.find(Angajat.class, 2);

        System.out.println(angajat);

        em.close();
        emf.close();
    }
}
