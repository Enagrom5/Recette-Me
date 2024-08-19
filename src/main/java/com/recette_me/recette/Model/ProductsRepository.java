package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{

}
