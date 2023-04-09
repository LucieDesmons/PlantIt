package com.plantit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//, exclude = SecurityAutoConfiguration.class

@ComponentScan({
        "com.plantit.auth",
        "com.plantit.config",
        "com.plantit.API.Controller",
        "com.plantit.controllers",
        "com.plantit.DATA.dal.entities",
        "com.plantit.DATA.dal.repositories",
        "com.plantit.BLL"})
@SpringBootApplication(scanBasePackages = {"com.plantit"},exclude = SecurityAutoConfiguration.class)
public class PlantItApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantItApplication.class, args);
    }

}
