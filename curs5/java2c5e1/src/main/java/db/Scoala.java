package db;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Scoala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tabela_materii")
    @MapKeyClass(Integer.class) // folosita pt a specifica tipul cheii
    @MapKeyColumn(name = "numar_credite") // configuram coloana folosita pentru stocarea cheilor mapului
    private Map<Integer, Materie> materii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Materie> getMaterii() {
        return materii;
    }

    public void setMaterii(Map<Integer, Materie> materii) {
        this.materii = materii;
    }
}
