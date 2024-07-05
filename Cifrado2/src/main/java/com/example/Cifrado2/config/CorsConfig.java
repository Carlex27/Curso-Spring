package com.example.Cifrado2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // Permitir todos los dominios
        config.addAllowedOrigin("*");
        // Permitir todos los métodos HTTP
        config.addAllowedMethod("*");
        // Permitir todas las cabeceras
        config.addAllowedHeader("*");
        // Permitir el envío de credenciales
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Aplicar la configuración de CORS a todas las rutas
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
