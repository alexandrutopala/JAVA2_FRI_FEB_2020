package db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUSE")
public class Produs {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "produs_name")
    private String name;


    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirare=" + expirare +
                ", categorie=" + categorie +
                '}';
    }

    @Basic(fetch = FetchType.EAGER)
    @Temporal(TemporalType.DATE)
    private Date expirare;

    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getExpirare() {
        return expirare;
    }

    public void setExpirare(Date expirare) {
        this.expirare = expirare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
