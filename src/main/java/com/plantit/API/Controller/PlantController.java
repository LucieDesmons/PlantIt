package com.plantit.API.Controller;

import com.plantit.DATA.dto.service.PlantService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plants")
@Api(value = "PlantController", tags = {"Plant Management"})
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }


}
