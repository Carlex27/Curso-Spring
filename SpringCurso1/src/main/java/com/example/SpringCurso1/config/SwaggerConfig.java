package com.example.SpringCurso1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Collections;

/**
 * Configuracion swagger para hacer la documentacion de la API REST
 * http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    //Con este bean se crea la licencia de la documentacion de API
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Curso 1")
                        .version("1.0")
                        .description("API REST de prueba")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }



}
