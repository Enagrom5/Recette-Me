package com.recette_me.recette.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recette_me.recette.entities.Comments.Comment;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer>{

     @Query("SELECT c, r.title, u.pseudo FROM Comment c JOIN c.recetteId r JOIN c.userId u")
    public List<Comment> findAllComments() ;

   @Query("SELECT c FROM Comment c WHERE c.userId.id = :id")
    public List<Comment>  findAllForUser(@Param("id") int id);

    @Query("SELECT c FROM Comment  c JOIN c.recetteId r JOIN c.userId u  WHERE r.id = :id")
    public List<Comment> findAllCommentsForRecipe(@Param("id") int id);
}
