package com.plantit.DATA.dto.service;

import com.plantit.DATA.dal.entities.Plant;

import java.util.List;

public interface PlantService {

    Plant createPlant(Plant p);

    Plant savePlant(Plant p);

    Plant updatePlant(Plant p);

    void deletePlant(Plant p);

    void deletePlantById(Long id);

    Plant getPlant(Long id);

    List<Plant> getAllPlants();

}
