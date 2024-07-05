package com.example.Cifrado2.controller;

import com.example.Cifrado2.entities.User;
import com.example.Cifrado2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/addNewUser")
    public String addNewUser(
            @RequestBody User user
    ){
        return userService.addUser(user);
    }

    @GetMapping("/userProfile")
    public String userProfile(){
        return "Welcome to UserProfile endpoint";
    }
}
