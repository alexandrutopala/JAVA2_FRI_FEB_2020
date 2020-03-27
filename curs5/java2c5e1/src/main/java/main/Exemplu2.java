package main;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu2 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var m = new Magazin();

        m.setDepartamente(Map.of(
                10, "Vanzari",
                20, "Suport"
        ));

        em.getTransaction().begin();

        em.persist(m);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
