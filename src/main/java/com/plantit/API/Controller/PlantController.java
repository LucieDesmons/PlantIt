package com.plantit.API.Controller;

import com.plantit.BLL.ManagePlant;
import com.plantit.DATA.dal.entities.Plant;
import com.plantit.DATA.dal.repositories.PlantRepository;
import com.plantit.DATA.dto.PlantDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plants")
@Api(value = "PlantController", tags = {"Plant Management"})
public class PlantController {
    private final ManagePlant managePlant;
    private final PlantRepository plantRepository;

    public PlantController(ManagePlant managePlant, PlantRepository plantRepository) {
        this.managePlant = managePlant;
        this.plantRepository = plantRepository;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new plant", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Plant created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<Plant> createPlant(@RequestBody PlantDTO plantDTO){
        Plant plant = managePlant.createPlant(plantDTO);
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }


}
