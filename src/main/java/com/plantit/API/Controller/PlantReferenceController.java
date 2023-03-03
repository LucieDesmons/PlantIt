package com.plantit.API.Controller;

import com.plantit.BLL.ManagePlantReference;
import com.plantit.DATA.dal.repositories.PlantReferenceRepository;
import com.plantit.DATA.dto.PlantReferenceDTO;
import com.plantit.DATA.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plantReferences")
@Api(value = "PlantReferenceController", tags = {"PlantReference Management"})
public class PlantReferenceController {
    private final ManagePlantReference managePlantReference;

    private final PlantReferenceRepository plantReferenceRepository;

    public PlantReferenceController(ManagePlantReference managePlantReference, PlantReferenceRepository plantReferenceRepository) {
        this.managePlantReference = managePlantReference;
        this.plantReferenceRepository = plantReferenceRepository;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new plantReference", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Plant reference created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<PlantReferenceDTO> createPlant(@RequestBody PlantReferenceDTO plantReferenceDTO){
        //Plant plantReference = managePlantReference.createPlant(plantDTO);
        //return new ResponseEntity<>(plantReference, HttpStatus.OK);
        PlantReferenceDTO createdPlant = managePlantReference.createPlantReference(plantReferenceDTO);
        return new ResponseEntity<>(createdPlant, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlantReferenceDTO>> listAllPlants(){
        return new ResponseEntity<>(managePlantReference.getPlantReferences(), HttpStatus.OK);
    }

    @GetMapping("/plantReference/{id}")
    public ResponseEntity<PlantReferenceDTO> getById(@PathVariable long id) {
        Optional<PlantReferenceDTO> dto = managePlantReference.getPlantReferenceById(id);

        if (dto.isPresent()){
            return new ResponseEntity<>(dto.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/plantReference/{id}")
    public void deletePlant(@PathVariable long id) {

        try {
            managePlantReference.deletePlantReference(id);

        }catch (Exception e){
            throw new NotFoundException("La plantReference n'existe pas²");
        }
    }
}
