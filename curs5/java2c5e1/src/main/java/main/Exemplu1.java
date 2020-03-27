package main;

import db.Fisier;
import db.Folder;

import javax.persistence.Persistence;
import java.util.List;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        Fisier fis1 = new Fisier();

        fis1.setNume("X");
        fis1.setLinii(List.of("linia X 1", "linia X 2"));

        Fisier fis2 = new Fisier();

        fis2.setNume("Y");
        fis2.setLinii(List.of("linia Y 1", "linia Y 2"));

        Folder f = new Folder();

        f.setNume("A");
        f.setFisiere(List.of(fis1, fis2));

        em.getTransaction().begin();

        em.persist(f);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
