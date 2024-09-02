package com.example.Oauth2_.Spring.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .securityMatcher(new AntPathRequestMatcher("/**"))
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/login**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(Customizer.withDefaults())
                .build();
    }

}
