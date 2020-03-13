package db;

import javax.persistence.*;

@Entity
public class Tricou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Marime marime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marime getMarime() {
        return marime;
    }

    public void setMarime(Marime marime) {
        this.marime = marime;
    }
}
