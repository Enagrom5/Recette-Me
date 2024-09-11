package com.recette_me.recette.entities.Comments;

import com.recette_me.recette.entities.Recettes.RecetteDto;
import com.recette_me.recette.entities.Users.UserDto;

import jakarta.validation.constraints.*;

public class CommentDto {

    @NotEmpty (message = "Vous devez mettre une note")
    private int note;

    @NotEmpty ()
    private UserDto userId;

    @NotEmpty
    private RecetteDto recetteId;

    @Size(min=10, message="Le commentaire doit faire au minimum 10 charactères")
    @Size(max=2000, message="Trop de charactère")
    private String userComment;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

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

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    

}
