package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Collection<Fisier> fisiere;

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

    public Collection<Fisier> getFisiere() {
        return fisiere;
    }

    public void setFisiere(Collection<Fisier> fisiere) {
        this.fisiere = fisiere;
    }
}
