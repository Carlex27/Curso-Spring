package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entities.AuthRequest;
import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.service.JwtService;
import com.example.SpringSecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private UserService service;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(
            @RequestBody User user
    ){
        return service.addUser(user);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('USER')")
    public User userProfile(Authentication authentication){
        String username = authentication.getName();
        return service.findUserByUsername(username);
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile(){
        return "Welcome to adminProfile endpoint";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(
            @RequestBody AuthRequest authRequest
    ){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        } else{
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }

}
