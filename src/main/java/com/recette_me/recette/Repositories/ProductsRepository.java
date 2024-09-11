package com.recette_me.recette.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{
 
}
