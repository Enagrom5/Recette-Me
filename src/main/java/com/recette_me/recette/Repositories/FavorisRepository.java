package com.recette_me.recette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.entities.Favoris.Favori;

public interface FavorisRepository extends JpaRepository<Favori, Integer>{

}
