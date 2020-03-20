package main;

import db.Buletin;
import db.Persoana;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();

        Buletin b1 = new Buletin();

        b1.setCod("RR123456");

        Persoana p1 = new Persoana();

        p1.setNume("gigel");
        p1.setBuletin(b1);

        em.getTransaction().begin();

        em.persist(b1);
        em.persist(p1);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
