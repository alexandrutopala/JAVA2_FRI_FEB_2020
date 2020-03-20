package main;

import db.Profesor;
import db.Scoala;

import javax.persistence.Persistence;
import java.util.List;

public class Exemplu4 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory(
                "java2c4PU"
        );

        var em = emf.createEntityManager();

        Profesor p1 = new Profesor();

        p1.setNume("Dorel");

        Profesor p2 = new Profesor();

        p2.setNume("Gigel");

        Scoala s1 = new Scoala();

        s1.setNume("nr. 123");
        //s1.setProfesori(List.of(p1, p2));

        em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);
        em.persist(s1);

        p1.setScoala(s1);
        p2.setScoala(s1);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
