package db;

import javax.persistence.*;
import java.util.Map;

@Entity
@Cacheable
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @MapKey(name = "strada") // numele coloanei din Adresa, din care
                            // va lua valoarea pentru a o pune drept cheie
                            // asociata valorii respective
    private Map<String, Adresa> adrese;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Adresa> getAdrese() {
        return adrese;
    }

    public void setAdrese(Map<String, Adresa> adrese) {
        this.adrese = adrese;
    }
}
