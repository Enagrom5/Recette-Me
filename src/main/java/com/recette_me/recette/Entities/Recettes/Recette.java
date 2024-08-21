package com.recette_me.recette.Entities.Recettes;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.recette_me.recette.Entities.Comments.Comment;
import com.recette_me.recette.Entities.Favoris.Favori;
import com.recette_me.recette.Entities.Users.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Recettes")
public class Recette {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Requis")
    private String title;

    @NotBlank(message = "Requis")
    private String category;

    @NotBlank(message = "Requis")
    private String type;


    @NotBlank(message = "Requis")
    @Column(columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON)
    private HashMap<String,String> ingredient = new HashMap<>();
    
    private int temperature;

    @NotBlank(message = "Requis")
    private int temps;

    @NotBlank(message = "Requis")
    @Column(columnDefinition = "TEXT")
    private String protocol;
    
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @OneToMany (mappedBy = "recetteId")
    private List<Favori> favoris;

    @OneToMany (mappedBy = "recetteId")
    private List<Comment> comments;
    
    public List<Favori> getFavoris() {
        return favoris;
    }


    public void setFavoris(List<Favori> favoris) {
        this.favoris = favoris;
    }


    public List<Comment> getComments() {
        return comments;
    }


    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return title;
    }

    public void setTitre(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(HashMap<String, String> ingredient) {
        this.ingredient = ingredient;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    
}
