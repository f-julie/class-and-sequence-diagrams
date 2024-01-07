package com.bloomtech.classandsequence.springtrails.models;

public class Trail {
    private static int maxId = 1;
    private int id;

    private String name;
    private TrailType trailType;
    private int parkId;

    public Trail() {
        this.id = maxId;
        maxId++;
    }

    public Trail(String name, TrailType trailType, int parkId) {
        this.id = maxId;
        maxId++;

        this.name = name;
        this.trailType = trailType;
        this.parkId = parkId;
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

    public TrailType getTrailType() {
        return trailType;
    }

    public void setTrailType(TrailType trailType) {
        this.trailType = trailType;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }
}
