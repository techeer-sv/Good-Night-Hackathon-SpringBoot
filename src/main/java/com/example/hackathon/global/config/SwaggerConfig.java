package com.example.hackathon.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI reviewOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Review API")
                .description("API for managing review"));
    }

}