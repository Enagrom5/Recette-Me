package com.recette_me.recette.Entities.Users;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {

    @NotEmpty(message = "Requis")
    private String lastName;

    @NotEmpty(message = "Requis")
    private String firstName;

    @NotEmpty(message = "Requis")
    private String pseudo;

    @NotEmpty(message = "Requis")
    private String email;

    @NotEmpty(message = "Requis")
    private String hashedpassword;

    @NotEmpty(message = "Requis")
    private String adress;

    @NotEmpty(message = "Requis")
    private Date born;

    @NotEmpty (message = "Requis")
    private MultipartFile imageFile;

}
