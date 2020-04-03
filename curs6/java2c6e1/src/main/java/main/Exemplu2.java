package main;

import db.Avocat;
import db.Programator;

import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var p = new Programator();

        p.setNume("gigel");
        p.setLimbaj("python");

        var a = new Avocat();

        a.setNume("costel");
        a.setVechime(3);

        em.getTransaction().begin();

        em.persist(a);
        em.persist(p);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
