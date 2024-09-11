package com.recette_me.recette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.recette_me.recette.entities.Ingredients.Ingredient;
import com.recette_me.recette.repositories.IngredientRepository;


@Service
public class IngredentService {
    @Autowired
    private IngredientRepository repo;

    public List<Ingredient> getAllIngredient (){
        
        return repo.findAll(Sort.by(Direction.ASC));
        
    }

    public String create(Ingredient ingredientObject){
        
    Ingredient ingredient = new Ingredient();
    
        try{
           
         ingredient.setName(ingredientObject.getName());
              repo.save(ingredient);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return ingredient.getName();
    }

        public void delete(int id){
            try{
                repo.deleteById(id);
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
}