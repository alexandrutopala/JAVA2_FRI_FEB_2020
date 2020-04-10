package dto;

import java.io.Serializable;
import java.time.Instant;

public class Mesaj implements Serializable {
    private final static long serialVersionUID = 1L;

    private String continut;

    private String expeditor;

    private Instant timestamp;

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public String getExpeditor() {
        return expeditor;
    }

    public void setExpeditor(String expeditor) {
        this.expeditor = expeditor;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return expeditor + ": " + continut + " (" + timestamp + ")";
    }

    public static Mesaj of(String expeditor, String continut) {
        Mesaj mesaj = new Mesaj();

        mesaj.expeditor = expeditor;
        mesaj.continut = continut;
        mesaj.timestamp = Instant.now();

        return mesaj;
    }
}
