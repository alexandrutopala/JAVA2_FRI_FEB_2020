package main;

import db.Bere;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Exemplu4 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        String sql = "SELECT * FROM produs WHERE nume = ?";
        Query q = em.createNativeQuery(sql, Bere.class);

        q.setParameter(1, "Stejar");

        List<Bere> beri = q.getResultList();

        beri.forEach(System.out::println);

        Bere b = (Bere) q.getSingleResult(); // imi intoarce o singura inregistrare,
                                             // sau arunca o exceptie daca sunt intoarse
                                            //  fie 2 sau mai multe, fie niciuna

        /*
            Concluzii query-uri native:
                - pierdem portabilitatea
                - nu actualizeaza contextul de persistenta
                - poate fi mai rapid (poate folosi optimizari particulare bazei de date cu care lucram)
         */

        em.close();
        emf.close();
    }
}
