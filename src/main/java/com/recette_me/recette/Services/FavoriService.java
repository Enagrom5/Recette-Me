package com.recette_me.recette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recette_me.recette.entities.Favoris.Favori;
import com.recette_me.recette.entities.Favoris.FavoriDto;
import com.recette_me.recette.repositories.FavorisRepository;
import com.recette_me.recette.repositories.RecettesRepository;
import com.recette_me.recette.repositories.UsersRepository;
import com.recette_me.recette.entities.Users.User;
import com.recette_me.recette.entities.Recettes.Recette;


    
@Service
public class FavoriService {

    @Autowired
    FavorisRepository favorisRepo;

    @Autowired
    UsersRepository usersRepo;

    @Autowired
    RecettesRepository recettesRepo;

    public List<Favori> findAllFavoris(){

        return favorisRepo.findAllFavoris();
    }

    public List<Favori> findAllForUser(int id){
        return favorisRepo.findAllForUser(id);
    }

    public List<Favori> findAllFavForRecipe(int id){
        return favorisRepo.findAllFavForRecipe(id);
    }

   

    public Favori create(FavoriDto favoriReceived) throws Exception{
        Favori favori = new Favori();
        User user = usersRepo.findById(favoriReceived.getUserId()).orElseThrow(() -> new Exception("Utilisateur non trouvé"));
        Recette recette = recettesRepo.findById(favoriReceived.getRecetteId()).orElseThrow(() -> new Exception("Recette non trouvée"));

        favori.setUser(user);
        favori.setRecette(recette);
        
        return favorisRepo.save(favori);
    }

    public String delete(int id){
        try {
            favorisRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Favori supprimé";
    }

}
