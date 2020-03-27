package main;

import db.Materie;
import db.Scoala;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu3 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var s = new Scoala();

        s.setMaterii(Map.of(
                3, Materie.INFO,
                7, Materie.LATINA
        ));

        em.getTransaction().begin();

        em.persist(s);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
