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
    private User userId;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recetteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Recette getRecetteId() {
        return recetteId;
    }

    public void setRecetteId(Recette recetteId) {
        this.recetteId = recetteId;
    }

    
    
}
