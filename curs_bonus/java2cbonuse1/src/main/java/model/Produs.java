package model;

import validation.ValidCategory;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Produs {

    @Min(0)
    @Max(10)
    private int pret;

    @NotEmpty
    @Max(5)
    private String nume;

    @ValidCategory
    @NotEmpty
    @Max(10)
    private String categorie;

    public String getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "pret=" + pret +
                ", nume='" + nume + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
