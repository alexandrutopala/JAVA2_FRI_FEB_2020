package db;

import javax.persistence.Entity;

@Entity
public class Avocat extends Angajat {

    public int getVechime() {
        return vechime;
    }

    public void setVechime(int vechime) {
        this.vechime = vechime;
    }

    private int vechime;
}
