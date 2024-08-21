package com.recette_me.recette.Controllers;

import java.io.InputStream;
import java.nio.file.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.recette_me.recette.Entities.Product;
import com.recette_me.recette.Entities.ProductDto;
import com.recette_me.recette.Repositories.ProductsRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsRepository repo;
    private String exception;

// READ ALL PRODUCT
    @GetMapping({"","/"})
    public String showProductList (Model model){
        //Demande au repo les info et les places dans une liste. 
        List<Product> products = repo.findAll(Sort.by(Direction.DESC,"createdAt"));
        //passe la liste a model qui va l'envoyer au template
        model.addAttribute("products", products);
        return "products/index";
    }

// CREATE PRODUCT
   @GetMapping("/create")
   public String showCreatePage(Model model){
    ProductDto productDto = new ProductDto();
    model.addAttribute("productDto",productDto);
    return "products/CreateProduct";
   } 


   @PostMapping("/create")
   public String createProduct(
    @Valid @ModelAttribute ProductDto productDto,
    BindingResult result
   ) {
    //check si il y a bien une image
    if (productDto.getImageFile().isEmpty()){
        result.addError(new FieldError("productDto","imageFile","The imageFile is required"));
    }
    //check si result contient des erreurs et si oui bloque sur la page create
    if (result.hasErrors()){
        return "products/CreateProduct";
    }
    //save image
    MultipartFile image = productDto.getImageFile();
    Date createdAt=new Date();
    String storageFileName = createdAt.getTime()+'_'+image.getOriginalFilename();

    try{
        String uploadDir = "public/images/";
        Path uploadPath=Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream=image.getInputStream()){
            Files.copy(inputStream,Paths.get(uploadDir+storageFileName),
            StandardCopyOption.REPLACE_EXISTING);
        }
    }
        catch(Exception ex){
            System.out.println(exception);
        }

        Product product = new Product();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCreatedAt(createdAt);
        product.setImageFileName(storageFileName);

        repo.save(product);
    
    return "redirect:/products";
   }


   // EDIT PRODUCT

    //take product
   @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id){
        try {
            Product product = repo.findById(id).get();
            model.addAttribute("product", product);

            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setBrand(product.getBrand());
            productDto.setCategory(product.getCategory());
            productDto.setPrice(product.getPrice());
            productDto.setDescription(product.getDescription());

            model.addAttribute("productDto",productDto);
            

        } catch (Exception ex) {
            System.out.println(exception);
            return "redirect:/products";
        }
        return "products/EditProduct";
}
    // update product
@PostMapping("/edit")
public String updateProduct(
    Model model,
    @RequestParam int id,
    @Valid @ModelAttribute ProductDto productDto,
    BindingResult result
){
    try {
        Product product = repo.findById(id).get();
        model.addAttribute("product", product);

        if (result.hasErrors()){
            return "products/EditProduct";
        }

        if(!productDto.getImageFile().isEmpty()){
            String uploadDir = "public/images/";
            Path oldImagePath = Paths.get(uploadDir+product.getImageFileName());

            try {
                Files.delete(oldImagePath);
            } catch (Exception ex) {
                System.out.println(exception);
            }
            MultipartFile image = productDto.getImageFile();
            Date createdAt=new Date();
            String storageFileName = createdAt.getTime()+'_'+image.getOriginalFilename();

            try(InputStream inputStream=image.getInputStream()){
                Files.copy(inputStream,Paths.get(uploadDir+storageFileName),
                StandardCopyOption.REPLACE_EXISTING);
            }
            product.setImageFileName(storageFileName);}

            product.setName(productDto.getName());
            product.setBrand(productDto.getBrand());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());

            repo.save(product);
        
    } catch (Exception ex) {
        System.out.println(exception);
    }
    return "redirect:/products";
}


//DELETE PRODUCT

   @GetMapping("/delete")
   public String deleteProduct (@RequestParam int id){
    System.out.println(id);
    try {
        //get le product a delete
        Product product = repo.findById(id).get();

        // delete l'image

        Path imagePath = Paths.get("public/images" + product.getImageFileName());

        try {
            Files.delete(imagePath);

        } catch (Exception ex) {
            System.out.println(exception);
        }


        repo.delete(product);
    } catch (Exception ex) {
        System.out.println(exception);
    }
    return "redirect:/products";
   }
}
