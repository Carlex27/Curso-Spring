package com.example.Cifrado2.controller;


import com.example.Cifrado2.entities.User;
import com.example.Cifrado2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;


    @PostMapping("/addNewUser")
    public String addNewUser(
            @RequestBody User user
    ){
        return userService.addUser(user);
    }



    @GetMapping("/userProfile")
    public User userProfile(Authentication authentication){
        String username = authentication.getName();
        return userService.getUserProfile(username);
    }

    @GetMapping("/adminProfile")
    public String adminProfile(){
        return "Welcome to adminProfile endpoint";
    }
}
