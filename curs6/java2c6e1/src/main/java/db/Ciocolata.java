package db;

import javax.persistence.Entity;

@Entity
public class Ciocolata extends Produs {

    private int zahar;

    public int getZahar() {
        return zahar;
    }

    public void setZahar(int zahar) {
        this.zahar = zahar;
    }
}
