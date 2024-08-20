package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.Recette;

public interface RecettesRepository extends JpaRepository<Recette, Integer>{

}
