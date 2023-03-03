package com.plantit.config.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi plantItAPI() {
        return GroupedOpenApi.builder()
                .group("PlantIt API")
                .pathsToMatch("/**")
                .displayName("PlantIt API")
                .build();
    }
}
