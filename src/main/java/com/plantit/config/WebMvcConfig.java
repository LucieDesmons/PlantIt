package com.plantit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /*@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("My API")
                .version("1.0")
                .description("API pour la gestion des produits")
                .contact(new Contact().name("John Doe").email("johndoe@example.com")));
    }*/

   /* @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/swagger-ui", HandlerTypePredicate.forAnnotation(Controller.class));
    }*/

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/swagger-ui").setViewName("swagger");
    }

}
