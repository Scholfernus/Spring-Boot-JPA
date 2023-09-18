package com.example.demo2.model.zad3;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Car extends Vehicle{
    private String name;
    private String cost;
}
