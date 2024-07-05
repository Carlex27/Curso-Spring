package com.example.Cifrado2.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String FirstName;
    private String LastName;
    private String username;
    private String email;
    private String password;

}
