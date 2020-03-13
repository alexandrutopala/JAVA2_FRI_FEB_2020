package service.impl;

import dao.PisicaDao;
import dao.impl.PisicaDaoImpl;
import entities.Pisica;
import service.PisicaService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PisicaServiceImpl implements PisicaService {

    private PisicaDao pisicaDao;

    public PisicaServiceImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3PU");
        EntityManager em = emf.createEntityManager();

        this.pisicaDao = new PisicaDaoImpl(em);
    }

    @Override
    public void persist(Pisica p) {
        pisicaDao.persist(p);
    }

    @Override
    public Pisica find(int id) {
        return pisicaDao.find(id);
    }

    @Override
    public void remove(int id) {
        Pisica p = find(id);
        pisicaDao.remove(p);
    }

    @Override
    public void refresh(Pisica p) {
        pisicaDao.refresh(p);
    }

    @Override
    public void modifica(int id, String nume) {
        Pisica p = new Pisica();

        p.setId(id);
        p.setNume(nume);

        pisicaDao.modifica(p);
    }
}
