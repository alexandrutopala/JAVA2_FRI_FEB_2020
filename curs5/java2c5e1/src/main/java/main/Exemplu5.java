package main;

import db.Persoana;

import javax.persistence.Persistence;

public class Exemplu5 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var p = em.find(Persoana.class, 2);

        System.out.println(p.getAdrese());

        // SELECT * FROM adrese WHERE pers_id = 1 AND strada = 'timisoara'
    }
}
