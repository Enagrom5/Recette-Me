package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.User;

public interface UsersRepository extends JpaRepository<User, Integer>{

}
