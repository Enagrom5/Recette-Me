package com.recette_me.recette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.recette_me.recette.entities.Product;


public interface ProductsRepository extends JpaRepository<Product, Integer>{
 
    
    
    
}
