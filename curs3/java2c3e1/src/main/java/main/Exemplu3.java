package main;

import db.Marime;
import db.Tricou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu3 {






    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3PU");
        EntityManager em = emf.createEntityManager();

        Tricou t = new Tricou();

        t.setMarime(Marime.M);

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
