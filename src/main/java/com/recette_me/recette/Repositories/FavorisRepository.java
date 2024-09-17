package com.recette_me.recette.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recette_me.recette.entities.Favoris.Favori;



@Repository
public interface FavorisRepository extends JpaRepository<Favori, Integer>{

    
    
    @Query("SELECT f, r.title, u.pseudo FROM Favori f JOIN f.recette r JOIN f.user u")
    public List<Favori> findAllFavoris() ;

   @Query("SELECT f FROM Favori f WHERE f.user.id = :id")
    public List<Favori>  findAllForUser(@Param("id") int id);

    @Query("SELECT f FROM Favori  f JOIN f.recette r JOIN f.user u  WHERE r.id = :id")
    public List<Favori> findAllFavForRecipe(@Param("id") int id);

}
