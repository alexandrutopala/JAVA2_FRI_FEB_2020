package db;

import javax.persistence.*;

@Entity
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @OneToOne
    private Buletin buletin;

    public Buletin getBuletin() {
        return buletin;
    }

    public void setBuletin(Buletin buletin) {
        this.buletin = buletin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
