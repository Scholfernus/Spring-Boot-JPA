package com.example.demo2.model.zad1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Component
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy =  "author")
    private List<Book>books;
}
