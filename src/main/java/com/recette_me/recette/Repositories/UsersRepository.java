package com.recette_me.recette.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.Entities.Users.User;

public interface UsersRepository extends JpaRepository<User, Integer>{

}
