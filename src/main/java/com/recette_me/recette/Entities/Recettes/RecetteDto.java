package com.recette_me.recette.entities.Recettes;

import java.util.HashMap;

import com.recette_me.recette.entities.Users.UserDto;

import jakarta.validation.constraints.NotEmpty;

public class RecetteDto {

    @NotEmpty(message = "Requis")
    private String title;

    @NotEmpty(message = "Requis")
    private String category;

    @NotEmpty(message = "Requis")
    private String type;

    @NotEmpty(message = "Requis")
    private HashMap<String,String> ingredient;

    public UserDto getUserId() {
        return userId;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }

    @NotEmpty(message = "Requis")
    private int temperature;

    @NotEmpty(message = "Requis")
    private int temps;

    @NotEmpty(message = "Requis")
    private String protocol;

    private UserDto userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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


    
}
