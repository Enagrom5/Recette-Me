package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.Igredient;

public interface IngredientRepository extends JpaRepository<Igredient, Integer>{

}
