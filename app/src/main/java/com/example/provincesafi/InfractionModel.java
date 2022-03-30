package com.example.provincesafi;

import java.io.Serializable;
import java.util.Date;

public class InfractionModel  implements Serializable {
    //ATTRIBUT
    private int id;
    private String name;
    private String cin;
    private String type;
    private String adresse;
    private String pv;
    /*private  String arrondissement;
    private String conduite;
    private  String commune ;*/

    //constructeur par défaut

    public InfractionModel() {
    }

    //constructeur

    public InfractionModel(int id, String name, String cin, String type, String adress, String pv) {
        this.id = id;
        this.name = name;
        this.cin = cin;
        this.type = type;
        this.adresse = adress;
        this.pv = pv;
    }


    //getters&setters

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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdress() {
        return adresse;
    }

    public void setAdress(String adress) {
        this.adresse = adress;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    //methodes

    @Override
    public String toString() {
        return "" +
                "" + id +
                ", '" + name + '\'' +
                ", '" + cin + '\'' +
                ", '" + type + '\'' +
                ", '" + adresse + '\'' +
                ", '" + pv + '\'' ;
    }
}

