package main;

import db.Adresa;
import db.Organizatie;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu6 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        Adresa a1 = new Adresa();

        a1.setStrada("Basarab");
        a1.setNumar(5);

        Organizatie o = new Organizatie();

        o.setStraziAdrese(Map.of(
                a1, a1.getStrada()
        ));

        em.getTransaction().begin();

        em.persist(a1);
        em.persist(o);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
