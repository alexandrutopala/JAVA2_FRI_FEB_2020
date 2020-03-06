package db;


import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Angajat {

    private int id;

    private String nume;

    private int varsta;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Access(AccessType.FIELD)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("setter id");
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        System.out.println("setter nume");

        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
