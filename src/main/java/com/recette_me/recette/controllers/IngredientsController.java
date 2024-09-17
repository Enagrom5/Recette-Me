package com.recette_me.recette.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recette_me.recette.entities.Ingredients.Ingredient;

import com.recette_me.recette.services.IngredentService;




// appel la fonction dans service et retourne le statut + le body avec la data

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    @Autowired
IngredentService ingredientService;
    

    @GetMapping({"","/"})
    public List<Ingredient> getAllIngredient (){
         
        return ingredientService.getAllIngredient();
        
    }
    
    @PostMapping("/create")
    public String create( @RequestBody Ingredient ingredientObject){
        
        
        System.out.println(ingredientObject);

         return ingredientService.create(ingredientObject);
         
        
    }

   @DeleteMapping("/delete")
    public String delete(@RequestParam int id){
        ingredientService.delete(id);
    
    return "supprimé";
    }

}
