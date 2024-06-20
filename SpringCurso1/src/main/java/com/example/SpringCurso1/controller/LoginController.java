package com.example.SpringCurso1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Anotacion que indica que esta clase es un controlador
@Controller
public class LoginController {

    //Metodo que retorna la vista Login
    //La vista Login se encuentra en src/main/resources/templates/Login.html
    //Es necesario tener la annotation @Controller
    @GetMapping("/login")
    public String login() {
        return "Login";
    }
}
