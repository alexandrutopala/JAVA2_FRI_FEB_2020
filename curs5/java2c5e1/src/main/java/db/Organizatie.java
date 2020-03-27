package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Organizatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    @MapKeyJoinColumn(name = "coloana_adresa")
    private Map<Adresa, String> straziAdrese;

    public Map<Adresa, String> getStraziAdrese() {
        return straziAdrese;
    }

    public void setStraziAdrese(Map<Adresa, String> straziAdrese) {
        this.straziAdrese = straziAdrese;
    }
}
