package main;

import db.Adresa;
import db.Organizatie;
import db.Persoana;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu4 {







    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3PU");
        EntityManager em = emf.createEntityManager();

        Adresa adresa = new Adresa();

        adresa.setNumar("3");
        adresa.setStrada("timisoare");

        Persoana persoana = new Persoana();

        persoana.setAdresa(adresa);
        persoana.setNume("gigel");

        Organizatie org = new Organizatie();

        org.setSite("www.org.com");
        org.setAdresa(adresa);

        em.getTransaction().begin();
        em.persist(persoana);
        em.persist(org);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
