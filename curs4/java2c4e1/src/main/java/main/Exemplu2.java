package main;

import db.Angajat;
import db.LocParcare;

import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory(
                "java2c4PU"
        );

        var em = emf.createEntityManager();

        Angajat a = new Angajat();

        a.setNume("Costel");

        LocParcare lp = new LocParcare();

        lp.setNumar(20);

        a.setLocParcare(lp);

        em.getTransaction().begin();

        em.persist(a);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
