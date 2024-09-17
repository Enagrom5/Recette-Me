package com.recette_me.recette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recette_me.recette.entities.Users.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer>{
    public User findByEmail (String email);
    
}
