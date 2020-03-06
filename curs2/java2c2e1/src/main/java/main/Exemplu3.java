package main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.stream.Stream;

public class Exemplu3 {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("java2c2PU");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Stream.iterate(1, i -> i + 1)
                    .limit(10)
                    .map(i -> new Angajat())
                    .peek(a -> a.setNume("dorel"))
                    .peek(a -> a.setVarsta(30))
                    .forEach(o -> {
                        em.persist(o);
                        em.flush();
                    });

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
