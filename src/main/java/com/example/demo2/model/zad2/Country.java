package com.example.demo2.model.zad2;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;
}
