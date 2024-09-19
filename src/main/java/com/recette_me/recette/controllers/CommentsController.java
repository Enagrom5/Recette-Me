package com.recette_me.recette.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.recette_me.recette.entities.Comments.Comment;
import com.recette_me.recette.entities.Comments.CommentDto;
import com.recette_me.recette.services.CommentService;


@RestController
public class CommentsController {
 @Autowired
    private CommentService CommentService;

    // Voir tout les comments du site
    @GetMapping("/admin/comments")
    public List<Comment> showAllComments(){
        return CommentService.findAllComments();
    }

    //Voir toutes les recettes fav d'un user
    @GetMapping("/users/{id}/comments")
    public ResponseEntity<List<Comment>> showAllCommentsPerUser(@PathVariable int id) throws Exception{
        List<Comment> result = CommentService.findAllForUser(id);
        // FIXME trouver une façon de retourner qu'il n'y a pas de comments pour cet utilisateur (par exemple avec un message)
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }


    //Voir tout les user qui ont mis fav sur une recette
    @GetMapping("/recettes/{id}/comments")
    public List<Comment> showRecetteComments(@PathVariable int id){

         // FIXME trouver une façon de retourner qu'il n'y a pas de comments pour cette recette (par exemple avec un message)
        return CommentService.findAllCommentsForRecipe(id);
    }

    // Créer un commentaire
    @PostMapping("comments/create")
    public ResponseEntity<Comment> createComment(@Validated @RequestBody CommentDto CommentReceived) {
        
        try {
            // Créer le comment à partir du DTO
           Comment createdComment = CommentService.create(CommentReceived);
            // Retourner une réponse avec le code 201 (Created) et le comment créé
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
        } catch (Exception e) {
            // En cas d'erreur, retourner une réponse avec le code 400 (Bad Request)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
}

    //Modifier un comment

    @PutMapping("comments/{id}")
    public String modifieComment(@PathVariable int id, @RequestBody CommentDto newComment) throws Exception{
        return CommentService.modifComment(id, newComment);
    }

    //Supprime un comment
    @DeleteMapping("comments/delete/{id}")
    public String deleteComment(@PathVariable int id){
        return CommentService.delete(id);

    }
}
