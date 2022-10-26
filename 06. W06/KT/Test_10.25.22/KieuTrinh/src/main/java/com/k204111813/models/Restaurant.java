package com.k204111813.models;

public class Restaurant {
    String name;
    int photo;
    Double rattingValue, rattingCount;
    String address;
//Constructor
    public Restaurant(String name, int photo, Double rattingValue, Double rattingCount, String address) {
        this.name = name;
        this.photo = photo;
        this.rattingValue = rattingValue;
        this.rattingCount = rattingCount;
        this.address = address;
    }
    //Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public Double getRattingValue() {
        return rattingValue;
    }

    public void setRattingValue(Double rattingValue) {
        this.rattingValue = rattingValue;
    }

    public Double getRattingCount() {
        return rattingCount;
    }

    public void setRattingCount(Double rattingCount) {
        this.rattingCount = rattingCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
