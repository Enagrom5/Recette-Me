package com.recette_me.recette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recette_me.recette.entities.Comments.Comment;
import com.recette_me.recette.entities.Comments.CommentDto;
import com.recette_me.recette.entities.Recettes.Recette;
import com.recette_me.recette.entities.Users.User;
import com.recette_me.recette.repositories.CommentsRepository;
import com.recette_me.recette.repositories.RecettesRepository;
import com.recette_me.recette.repositories.UsersRepository;

@Service
public class CommentService {

    @Autowired
    CommentsRepository commentsRepo;
    
    @Autowired
    UsersRepository usersRepo;

    @Autowired
    RecettesRepository recettesRepo;

    public List<Comment> findAllComments(){

        return commentsRepo.findAllComments();
    }

    public List<Comment> findAllForUser(int id){
        return commentsRepo.findAllForUser(id);
    }

    public List<Comment> findAllCommentsForRecipe(int id){
        return commentsRepo.findAllCommentsForRecipe(id);
    }

   

    public Comment create(CommentDto CommentReceived) throws Exception{
        Comment comment = new Comment();
        User user = usersRepo.findById(CommentReceived.getUserId()).orElseThrow(() -> new Exception("Utilisateur non trouvé"));
        Recette recette = recettesRepo.findById(CommentReceived.getRecetteId()).orElseThrow(() -> new Exception("Recette non trouvée"));

        comment.setUserId(user);
        comment.setRecetteId(recette);
        comment.setNote(CommentReceived.getNote());
        comment.setUserComment(CommentReceived.getUserComment());
        
        return commentsRepo.save(comment);
    }

    public String delete(int id){
        try {
            commentsRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Commentaire supprimé";
    }
}
