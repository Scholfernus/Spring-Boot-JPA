package com.example.demo2.model.zad2;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
