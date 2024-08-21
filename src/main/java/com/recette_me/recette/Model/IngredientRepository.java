package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.Ingredients.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

}
