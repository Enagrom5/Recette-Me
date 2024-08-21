package com.recette_me.recette.dataPattern;

import jakarta.persistence.*;

@Entity
@Table(name="Favoris")
public class Favori {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private int recetteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecetteId() {
        return recetteId;
    }

    public void setRecetteId(int recetteId) {
        this.recetteId = recetteId;
    }
    
}
