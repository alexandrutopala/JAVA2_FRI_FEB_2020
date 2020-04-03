package main;

import db.Bere;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/*
    JPQL - Java Persistence Query Language
    Este o abstractizare a limbajelor sql.
    Foloseste entitatile definite.
    Pot fi folosite doar pentru a face SELECT, UPDATE sau DELETE
    Nu actualizeaza contextul
 */
public class Exemplu5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        // nativ     "SELECT * FROM bere"
        String sql = "SELECT b FROM Bere b WHERE b.alcool = ?0 AND b.nume = :nume";
        TypedQuery<Bere> q = em.createQuery(sql, Bere.class);

        // ?0 parametru dat prin index
        q.setParameter(0, 7);

        // setarea unui named parameter
        q.setParameter("nume", "Stejar");

        List<Bere> beri = q.getResultList();

        beri.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
