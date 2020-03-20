package main;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.List;

public class Exemplu6 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory(
                "java2c4PU"
        );

        var em = emf.createEntityManager();

        Magazin m1 = new Magazin();

        m1.setNume("Mega");
        m1.setNumere(List.of("123", "000", "4321"));

        em.getTransaction().begin();

        em.persist(m1);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
