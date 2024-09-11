package com.recette_me.recette.entities.Favoris;

import com.recette_me.recette.entities.Recettes.RecetteDto;
import com.recette_me.recette.entities.Users.UserDto;

import jakarta.validation.constraints.NotEmpty;

public class FavoriDto {

    @NotEmpty
    private UserDto userId;

    @NotEmpty
    private RecetteDto recetteId;

    public UserDto getUserId() {
        return userId;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }

    public RecetteDto getRecetteId() {
        return recetteId;
    }

    public void setRecetteId(RecetteDto recetteId) {
        this.recetteId = recetteId;
    }

    
}
