package com.recette_me.recette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.entities.Recettes.Recette;

public interface RecettesRepository extends JpaRepository<Recette, Integer>{

}
