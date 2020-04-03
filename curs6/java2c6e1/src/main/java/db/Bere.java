package db;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Bere.findAll", query = "SELECT b FROM Bere b")
})
public class Bere extends Produs {

    private int procentAlcool;

    public int getProcentAlcool() {
        return procentAlcool;
    }

    public void setProcentAlcool(int procentAlcool) {
        this.procentAlcool = procentAlcool;
    }
}
