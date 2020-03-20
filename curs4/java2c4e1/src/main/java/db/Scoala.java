package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Scoala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    // One Scoala to Many Profesor
    @OneToMany(mappedBy = "scoala")
    private Collection<Profesor> profesori;

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

    public Collection<Profesor> getProfesori() {
        return profesori;
    }

    public void setProfesori(Collection<Profesor> profesori) {
        this.profesori = profesori;
    }
}
