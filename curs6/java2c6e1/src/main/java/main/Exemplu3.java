package main;

import db.NumePrenumeId;
import db.Persoana;
import db.Student;

import javax.persistence.Persistence;

public class Exemplu3 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        Persoana p = new Persoana();

        NumePrenumeId id = new NumePrenumeId();

        id.setNume("dorel");
        id.setPrenume("ion");

        p.setId(id);
        p.setVarsta(25);

        Student s = new Student();

        s.setNume("pop");
        s.setPrenume("maria");

        em.getTransaction().begin();

        em.persist(p);
        em.persist(s);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
