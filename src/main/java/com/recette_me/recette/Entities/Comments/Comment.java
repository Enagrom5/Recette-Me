package com.recette_me.recette.Entities.Comments;

import com.recette_me.recette.Entities.Recettes.Recette;
import com.recette_me.recette.Entities.Users.User;

import jakarta.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "recette_id")
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
