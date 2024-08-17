package com.recette_me.recette.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{

}
