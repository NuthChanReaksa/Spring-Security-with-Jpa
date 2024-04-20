package org.example.springsecuritybasic.restControllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleRestController {
//    @GetMapping("/login")
//    public String login(){
//        return "Welcome to the Articles Page!";
//    }
//    @GetMapping("/sign-up")
//    public String logout(){
//        return "You have been logged up !";
//    }

    @GetMapping
    public String getAllArticles(){
        return "Welcome to the Articles Page!";
    }
    @GetMapping("/read/{id}")
    public String readSingleArticles(@PathVariable int id){
        return "reading article with id: "+id;
    }

    @PostMapping("/write")
    public String createArticle(){
        return "Article created successfully!";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id){
        return "Article with id: "+id+" deleted successfully!";
    }


}
