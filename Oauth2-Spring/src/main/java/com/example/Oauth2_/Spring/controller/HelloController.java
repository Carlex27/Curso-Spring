package com.example.Oauth2_.Spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller //Controlador mvc
public class HelloController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/page1")
    public String page1(Model model){
        model.addAttribute("message", "Hola desde Spring mvc");
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client){
        log.info("Client name: " + client.getClientRegistration().getClientName());
        log.info("Access token: " + client.getAccessToken().getTokenValue());
        log.info("Username: " + client.getPrincipalName());
        return "page2";
    }


}
