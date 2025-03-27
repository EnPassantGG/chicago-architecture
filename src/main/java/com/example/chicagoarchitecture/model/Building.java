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

    @Column(name = "district")
    private String district;

    @Column(name = "is_endorsed",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isEndorsed;


    public Building(String name, String address, String city, int creationYear, String district, boolean isEndorsed) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.creationYear = creationYear;
        this.district = district;
        this.isEndorsed = isEndorsed;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public boolean isEndorsed() {
        return isEndorsed;
    }

    public void setEndorsed(boolean endorsed) {
        isEndorsed = endorsed;
    }


    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", creationYear=" + creationYear +
                ", district='" + district + '\'' +
                ", isEndorsed=" + isEndorsed +
                '}';
    }
}
