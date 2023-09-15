package com.example.demo2.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    public Recipe() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
