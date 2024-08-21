package com.recette_me.recette.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.Entities.Comments.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Integer>{

}
