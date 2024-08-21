package com.recette_me.recette.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.Entities.Ingredients.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

}
