package com.recette_me.recette.entities.Favoris;





public class FavoriDto {
    private int userId;
    private int recetteId;

    // Constructeurs, getters et setters
    public FavoriDto() {}

    public FavoriDto(int userId, int recetteId) {
        this.userId = userId;
        this.recetteId = recetteId;
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

