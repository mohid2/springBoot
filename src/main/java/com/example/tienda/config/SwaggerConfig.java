package com.example.tienda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.ejerccio1.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Ejemplo api REST",
                "Aprediendo spring boot",
                "1.0.0",
                "www.api.com",
                new Contact("Mohammed","www.api.com","mohammed@gmail.com"),
                "Standar",
                "www.standar.com",
                Collections.emptyList());
    }
}
