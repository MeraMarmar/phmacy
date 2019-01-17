package com.example.allinone.sw_project2;

public class Medecine {
    String id ,name , price,potion , nameOfcompany,quntity,kind,date ;

    public Medecine(String id, String name, String price, String potion, String nameOfcompany, String quntity, String kind, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.potion = potion;
        this.nameOfcompany = nameOfcompany;
        this.quntity = quntity;
        this.kind = kind;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public String getNameOfcompany() {
        return nameOfcompany;
    }

    public void setNameOfcompany(String nameOfcompany) {
        this.nameOfcompany = nameOfcompany;
    }

    public String getQuntity() {
        return quntity;
    }

    public void setQuntity(String quntity) {
        this.quntity = quntity;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
