package com.plantit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.plantit.API.Controller",
        "com.plantit.DATA.dal.entities",
        "com.plantit.DATA.dal.repositories",
        "com.plantit.DATA.dto.service",
        "com.plantit.DATA.dto.service.impl",
        "com.plantit.BLL"})
@SpringBootApplication(scanBasePackages = {"com.plantit"})
public class PlantItApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantItApplication.class, args);
    }

}
