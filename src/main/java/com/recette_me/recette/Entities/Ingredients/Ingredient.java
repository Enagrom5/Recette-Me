package com.recette_me.recette.entities.Ingredients;

import jakarta.persistence.*;

@Entity
@Table(name="Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
