package com.recette_me.recette.entities.Favoris;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.recette_me.recette.entities.Recettes.Recette;
import com.recette_me.recette.entities.Users.User;

import jakarta.persistence.*;

@Entity
@Table(name="Favoris")
public class Favori {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    @JsonBackReference
    private Recette recette;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

   

    

    

    
    
}
