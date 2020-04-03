package db;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String nume;

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
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
