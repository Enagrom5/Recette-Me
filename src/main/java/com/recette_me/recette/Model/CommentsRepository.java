package com.recette_me.recette.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recette_me.recette.dataPattern.Comments.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Integer>{

}
