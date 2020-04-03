package main;

import db.Bere;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Exemplu6 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        TypedQuery<Bere> q = em.createNamedQuery("Bere.findAll", Bere.class);

        List<Bere> beri = q.getResultList();

        beri.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
