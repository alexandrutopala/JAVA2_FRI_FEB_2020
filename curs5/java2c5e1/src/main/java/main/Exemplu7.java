package main;

import db.Persoana;

import javax.persistence.Cache;
import javax.persistence.Persistence;

public class Exemplu7 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em1 = emf.createEntityManager();
        var em2 = emf.createEntityManager();

        Cache cache = emf.getCache();

        System.out.println( cache.contains(Persoana.class, 1) );

        Persoana p = em1.find(Persoana.class, 1);

        System.out.println( cache.contains(Persoana.class, 1) );

        Persoana p1 = em2.find(Persoana.class, 1);

        cache.evict(Persoana.class); // sterge din cache toate instantele unei persoane
                                    // sau a unor clase care mostenesc Persoana

        cache.evict(Persoana.class, 1); // sterge din cache persoana cu id-ul 1

        cache.evictAll(); // sterge toate elementele din cache
    }
}
