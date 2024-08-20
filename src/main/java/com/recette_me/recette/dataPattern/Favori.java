package com.recette_me.recette.dataPattern;

import jakarta.persistence.*;

@Entity
@Table(name="Favoris")
public class Favori {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
}
