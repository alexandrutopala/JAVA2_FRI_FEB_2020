package service;

import entities.Pisica;

public interface PisicaService {

    void persist(Pisica p);

    Pisica find(int id);

    void remove(int id);

    void refresh(Pisica p);

    void modifica(int id, String nume);
}
