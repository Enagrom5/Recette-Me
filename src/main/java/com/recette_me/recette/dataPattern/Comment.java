package com.recette_me.recette.dataPattern;

import jakarta.persistence.*;

@Entity
@Table(name="Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
}
