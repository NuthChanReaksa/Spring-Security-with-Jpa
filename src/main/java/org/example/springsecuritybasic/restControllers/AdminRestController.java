package org.example.springsecuritybasic.restControllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
public class AdminRestController {
    @GetMapping
    public String getAllUsers(){
        return "These are all the user!";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return "User with id: "+id+" deleted successfully!";
    }
}
