package com.recette_me.recette.dataPattern;


import java.util.Date;
import java.util.HashMap;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name="Recettes")
public class Recette {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String category;
    private String type;
    @Column(columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON)
    private HashMap<String,String> ingredient = new HashMap<>();
    private int temperature;
    private int temps;

    @Column(columnDefinition = "TEXT")
    private String protocol;
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
}
