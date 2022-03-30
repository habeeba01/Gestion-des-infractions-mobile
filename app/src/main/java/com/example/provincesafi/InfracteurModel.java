package com.example.provincesafi;
//package org.o7planning.sqlitedemo.provincesafi ;
import java.io.Serializable;

public class InfracteurModel  implements Serializable{
    //attribut
    private int id ;
    private String name ;
    private String cin ;
    //constructeur par défaut
    public InfracteurModel() {
    }
    //constructeur

    public InfracteurModel(int id, String name, String cin) {
        this.id = id;
        this.name = name;
        this.cin = cin;
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

//méthodes


    @Override
    public String toString() {
        return "InfracteurModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cin='" + cin + '\'' +
                '}';
    }
}
