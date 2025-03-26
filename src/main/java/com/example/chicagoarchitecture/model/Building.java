package com.example.chicagoarchitecture.model;

public class Building {

    private String name;
    private String address;
    private String city;
    private int creationYear;

    public Building(String name, String address, String city, int creationYear) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", creationYear=" + creationYear +
                '}';
    }
}
