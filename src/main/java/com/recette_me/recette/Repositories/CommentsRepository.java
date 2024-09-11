package com.recette_me.recette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.entities.Comments.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Integer>{

}
