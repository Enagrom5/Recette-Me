package com.recette_me.recette.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.Entities.Favoris.Favori;

public interface FavorisRepository extends JpaRepository<Favori, Integer>{

}
