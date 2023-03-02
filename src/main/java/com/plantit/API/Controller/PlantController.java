package com.plantit.API.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plantit.BLL.ManagePlant;
import com.plantit.BLL.ManageUser;
import com.plantit.DATA.dal.entities.Plant;
import com.plantit.DATA.dal.repositories.PlantRepository;
import com.plantit.DATA.dto.PlantDTO;
import com.plantit.DATA.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plants")
@Api(value = "PlantController", tags = {"Plant Management"})
public class PlantController {
    private final ManagePlant managePlant;

    private final ManageUser manageUser;
    private final PlantRepository plantRepository;

    private ObjectMapper objectMapper;

    public PlantController(ManagePlant managePlant, ManageUser manageUser, PlantRepository plantRepository) {
        this.managePlant = managePlant;
        this.manageUser = manageUser;
        this.plantRepository = plantRepository;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new plant", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Plant created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<PlantDTO> createPlant(@RequestBody PlantDTO plantDTO){
        //Plant plant = managePlant.createPlant(plantDTO);
        //return new ResponseEntity<>(plant, HttpStatus.OK);
        PlantDTO truc = managePlant.createPlant(plantDTO);
        return new ResponseEntity<>(plantDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<PlantDTO> listAllPlants(){
        return managePlant.getPlants();
    }

    @GetMapping("/plant{id}")
    public ResponseEntity<PlantDTO> getById(@PathVariable long id) {
        Optional<PlantDTO> dto = managePlant.getPlantById(id);

        if (dto.isPresent()){
            return new ResponseEntity<>(dto.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
