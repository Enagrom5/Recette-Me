package com.recette_me.recette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.recette_me.recette.entities.Ingredients.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

}
