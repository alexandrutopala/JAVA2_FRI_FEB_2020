package main;

import db.Curs;
import db.Student;

import javax.persistence.Persistence;
import java.util.List;

public class Exemplu5 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory(
                "java2c4PU"
        );

        var em = emf.createEntityManager();

        Curs c1 = new Curs();

        c1.setNume("mate");

        Curs c2 = new Curs();

        c2.setNume("Fizica 2");

        Student s1 = new Student();

        s1.setSerie(10);

        Student s2 = new Student();

        s2.setSerie(20);

        s1.setCursuri(List.of(c1, c2));
        s2.setCursuri(List.of(c1, c2));

        em.getTransaction().begin();

        em.persist(s1);
        em.persist(s2);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
