package com.recette_me.recette.recette.models;

import jakarta.persistence.*;


@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private String firstName;
    private String pseudo;
    private String birthday;
    private String email;
    private String hashPassword;
    private String adress;


}
