package main;

import db.Categorie;
import db.Produs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;

public class Exemplu1 {






    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3PU");
        EntityManager em = emf.createEntityManager();

        Produs p1 = new Produs();

        p1.setName("ciocolata");
        p1.setExpirare(Date.valueOf(LocalDate.of(2020, 3, 30)));
        p1.setCategorie(Categorie.ALIMENTAR);

        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
