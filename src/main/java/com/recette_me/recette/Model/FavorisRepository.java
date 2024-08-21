package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.Favoris.Favori;

public interface FavorisRepository extends JpaRepository<Favori, Integer>{

}
