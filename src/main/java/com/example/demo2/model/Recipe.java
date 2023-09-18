package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Slf4j
@Entity
public class Recipe {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String description;
private Integer prepTime;
//@Column(name = "cook-time")
private Integer cookTime;
private Integer serving;
private String source;
//@Column(length = 400) można dodać długość
//    @Email można wymagać
private String url;

@Lob
private Byte[] image;
@OneToOne
private Notes notes;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
private Set<Ingredient> ingredients
 = new HashSet<>();
@ManyToMany
    @JoinTable(name = "recipe_category",joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
private Set<Category> categories = new HashSet<>();


    public Recipe(Long id, String description, Integer prepTime, Integer cookTime, Integer serving, String source, String url, Byte[] image, Notes notes, Set<Ingredient> ingredients, Set<Category> categories) {
        this.id = id;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.serving = serving;
        this.source = source;
        this.url = url;
        this.image = image;
        this.notes = notes;
        this.ingredients = ingredients;
        this.categories = categories;
    }
//nie powinno się używać w konstruktorze id, przez autoinkrementację
}
