package com.example.chicagoarchitecture.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "is_endorsed",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isEndorsed;
}
