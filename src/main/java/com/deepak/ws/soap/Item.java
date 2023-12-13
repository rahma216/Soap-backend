package com.deepak.ws.soap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Item {

    private String labelle;
    private int accidents;
    private int tues;
    private int blesses;

    @XmlElement
    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    @XmlElement
    public int getAccidents() {
        return accidents;
    }

    public void setAccidents(int accidents) {
        this.accidents = accidents;
    }

    @XmlElement
    public int getTues() {
        return tues;
    }

    public void setTues(int tues) {
        this.tues = tues;
    }

    @XmlElement
    public int getBlesses() {
        return blesses;
    }

    public void setBlesses(int blesses) {
        this.blesses = blesses;
    }

    @Override
    public String toString() {
        return "Item{" +
                "labelle='" + labelle + '\'' +
                ", accidents=" + accidents +
                ", tues=" + tues +
                ", blesses=" + blesses +
                '}';
    }
}
