package dao;

import entities.Pisica;

public interface PisicaDao {

    void persist(Pisica p);

    Pisica find(int id);

    void remove(Pisica p);

    Pisica refresh(Pisica p);

    Pisica merge(Pisica p);

    void detach(Pisica p);

    void clear();

    void modifica(Pisica p);
}
