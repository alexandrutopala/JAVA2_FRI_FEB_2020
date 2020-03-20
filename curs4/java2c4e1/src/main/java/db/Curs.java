package db;

import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Curs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    @ManyToMany(mappedBy = "cursuri")
    private Collection<Student> studenti;

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

    public Collection<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Collection<Student> studenti) {
        this.studenti = studenti;
    }
}
