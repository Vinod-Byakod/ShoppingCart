package com.example.Kart;

public class Product {
    private String id;
    private String name;

    //default constructor
    public Product() {

    }

    //constructor using fields
    public Product(String id, String name) {
        super();
        this.id = id;
        this.name = name;

    }

    //getters and setters
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


}