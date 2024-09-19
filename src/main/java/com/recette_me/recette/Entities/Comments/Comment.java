package com.recette_me.recette.entities.Comments;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.recette_me.recette.entities.Recettes.Recette;
import com.recette_me.recette.entities.Users.User;

import jakarta.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User userId;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    @JsonBackReference
    private Recette recetteId;

    private int note;

    @Column (columnDefinition = "TEXT")
    private String userComment;
    

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

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
    

}
