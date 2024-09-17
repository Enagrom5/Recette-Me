package com.recette_me.recette.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recette_me.recette.entities.Favoris.Favori;
import com.recette_me.recette.entities.Favoris.FavoriDto;
import com.recette_me.recette.services.FavoriService;

@RestController
public class FavorisController {

    @Autowired
    private FavoriService favorisService;

    // Voir tout les favoris du site
    @GetMapping("/admin/favoris")
    public List<Favori> showAllFavori(){
        return favorisService.findAllFavoris();
    }

    //Voir toutes les recettes fav d'un user
    @GetMapping("/users/{id}/favoris")
    public ResponseEntity<List<Favori>> showAllFavoriPerUser(@PathVariable int id) throws Exception{
        List<Favori> result = favorisService.findAllForUser(id);
        // FIXME trouver une façon de retourner qu'il n'y a pas de favoris pour cet utilisateur (par exemple avec un message)
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }


    //Voir tout les user qui ont mis fav sur une recette
    @GetMapping("/recettes/{id}/favoris")
    public List<Favori> showRecetteFavori(@PathVariable int id){

         // FIXME trouver une façon de retourner qu'il n'y a pas de favoris pour cette recette (par exemple avec un message)
        return favorisService.findAllFavForRecipe(id);
    }

    // Créer un favori
    @PostMapping("favoris/create")
    public ResponseEntity<Favori> createFavori(@Validated @RequestBody FavoriDto favoriReceived) {
        
        try {
            // Créer le favori à partir du DTO
            Favori createdFavori = favorisService.create(favoriReceived);
            // Retourner une réponse avec le code 201 (Created) et le favori créé
            return new ResponseEntity<>(createdFavori, HttpStatus.CREATED);
        } catch (Exception e) {
            // En cas d'erreur, retourner une réponse avec le code 400 (Bad Request)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
}

    //Supprime un favori
    @DeleteMapping("favoris/delete/{id}")
    public String deleteFavori(@PathVariable int id){
        return favorisService.delete(id);

    }
}
