package db;

import javax.persistence.Entity;

@Entity
public class Programator extends Angajat {

    private String limbaj;

    public String getLimbaj() {
        return limbaj;
    }

    public void setLimbaj(String limbaj) {
        this.limbaj = limbaj;
    }
}
