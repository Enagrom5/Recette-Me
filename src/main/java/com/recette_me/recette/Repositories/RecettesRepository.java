package com.recette_me.recette.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.Entities.Recettes.Recette;

public interface RecettesRepository extends JpaRepository<Recette, Integer>{

}
