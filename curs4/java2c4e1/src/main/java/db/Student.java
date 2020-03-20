package db;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serie;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "TABELA_MEA_DE_LEGATURA",
                joinColumns = @JoinColumn(name = "STUDENT_ID"),
                inverseJoinColumns = @JoinColumn(name = "CURS_ID"))
    private Collection<Curs> cursuri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public Collection<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(Collection<Curs> cursuri) {
        this.cursuri = cursuri;
    }
}
