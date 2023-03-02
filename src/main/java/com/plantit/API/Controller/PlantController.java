package com.plantit.API.Controller;

import com.plantit.BLL.ManagePlant;
import com.plantit.BLL.ManageUser;
import com.plantit.DATA.dal.repositories.PlantRepository;
import com.plantit.DATA.dto.PlantDTO;
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
@RequestMapping("/api/plants")
@Api(value = "PlantController", tags = {"Plant Management"})
public class PlantController {
    private final ManagePlant managePlant;
    private final ManageUser manageUser;
    private final PlantRepository plantRepository;

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
        PlantDTO createdPlant = managePlant.createPlant(plantDTO);
        return new ResponseEntity<>(createdPlant, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<PlantDTO> listAllPlants(){
        return managePlant.getPlants();
    }

    @GetMapping("/plant/{id}")
    public ResponseEntity<PlantDTO> getById(@PathVariable long id) {
        Optional<PlantDTO> dto = managePlant.getPlantById(id);

        if (dto.isPresent()){
            return new ResponseEntity<>(dto.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/plant/{id}")
    public void deletePlant(@PathVariable long id) {

        try {
            managePlant.deletePlant(id);

        }catch (Exception e){
            throw new NotFoundException("La plant n'existe pas²");
        }
    }

    @GetMapping("/{idUser}/plants")
    public ResponseEntity<List<PlantDTO>> getUserPLants(@PathVariable long idUser) {
        List<PlantDTO> userPlants = managePlant.getPlantFromIdUser(idUser);

        return new ResponseEntity<>(userPlants, HttpStatus.OK);
    }

}
