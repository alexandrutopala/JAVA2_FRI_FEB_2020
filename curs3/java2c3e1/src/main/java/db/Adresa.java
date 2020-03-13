package db;

import javax.persistence.Embeddable;

@Embeddable
public class Adresa {

    private String strada;

    private String numar;

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }
}
