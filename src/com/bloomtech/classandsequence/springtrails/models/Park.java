package com.bloomtech.classandsequence.springtrails.models;

public class Park {
    private static int maxId = 1;
    private int id;
    private String name;
    private String location;

    public Park() {
        this.id = maxId;
        maxId++;
    }

    public Park(String name, String location) {
        this.id = maxId;
        maxId++;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
