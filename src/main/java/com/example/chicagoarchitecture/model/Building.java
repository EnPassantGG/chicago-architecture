package com.example.chicagoarchitecture.model;

import jakarta.persistence.*;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "creation_year")
    private int creationYear;


    public Building(String name, String address, String city, int creationYear) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.creationYear = creationYear;
    }

    public Building() {}


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
