package main;

import db.Bere;
import db.Ciocolata;

import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var c = new Ciocolata();

        c.setNume("Milka");
        c.setZahar(20);

        var b = new Bere();

        b.setNume("heineken");
        b.setProcentAlcool(4);

        em.getTransaction().begin();

        em.persist(c);
        em.persist(b);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
