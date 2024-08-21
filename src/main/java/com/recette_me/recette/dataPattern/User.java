package com.recette_me.recette.dataPattern;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String pseudo;
    private Boolean admin;
    private String email;
    private String hashedPassword;
    private String adress;
    private Date signInAt;
    private Date born;

    @OneToMany (mappedBy = "userId")
    private List<Recette> recettes;

    @OneToMany (mappedBy = "userId")
    private List<Favori> favoris;

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
    @OneToMany (mappedBy = "userId")
    private List<Comment> comments;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public Date getSignInAt() {
        return signInAt;
    }
    public void setSignInAt(Date signInAt) {
        this.signInAt = signInAt;
    }
    public Date getBorn() {
        return born;
    }
    public void setBorn(Date born) {
        this.born = born;
    }
    public List<Recette> getRecettes() {
        return recettes;
    }
    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;
    }

    

}
