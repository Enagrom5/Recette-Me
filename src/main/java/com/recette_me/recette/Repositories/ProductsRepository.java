package com.recette_me.recette.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.Entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{
 
}
