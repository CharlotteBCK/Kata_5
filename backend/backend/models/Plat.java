package com.kata5.backend.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "plat")
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;


    @Column(nullable = false, lenght = 255)
    private String nom;

    @Column(nullable = false, lenght = 255)
    private String description;

    @Column(nullable = false)
    private double prix;

    @Column(nullable = false, lenght = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "Plat_ingredients",
        joinColumns = @JoinColumn(name = "id_plat"),
        inverseJoinColumns = @JoinColumn(name = "id_ingredients")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrix() {
        return prix;
    }
    
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public Set<Commande> getCommandes() {
        return commandes;
    }
    
    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
    
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
    
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

    





