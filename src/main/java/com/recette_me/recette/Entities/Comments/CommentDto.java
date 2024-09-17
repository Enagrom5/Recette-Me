package com.recette_me.recette.entities.Comments;




public class CommentDto {


    
    private int note;

    
    private int userId;

    
    private int recetteId;

    
    private String userComment;

    public CommentDto (int note, int userId, int recetteId, String userComment){
        this.note = note;
        this.userId = userId;
        this.recetteId = recetteId;
        this.userComment = userComment;

    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    
}
