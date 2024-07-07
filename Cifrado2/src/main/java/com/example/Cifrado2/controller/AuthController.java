package com.example.Cifrado2.controller;

import com.example.Cifrado2.dto.AuthDTO;
import com.example.Cifrado2.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(
            @RequestBody AuthDTO authDTO
    ){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDTO.getUsername(),
                        authDTO.getPassword()
                )
        );
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authDTO.getUsername());
        }else {
            throw new UsernameNotFoundException("User not found" + authDTO.getUsername());
        }
    }

}
