package db;

import javax.persistence.AssociationOverride;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Persoana {

    @EmbeddedId // marcam cheia primara compusa implementata printr-un Embeddable
    private NumePrenumeId id;

    private int varsta;

    public NumePrenumeId getId() {
        return id;
    }

    public void setId(NumePrenumeId id) {
        this.id = id;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
