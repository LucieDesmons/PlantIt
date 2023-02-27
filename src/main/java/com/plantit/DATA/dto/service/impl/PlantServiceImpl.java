package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Plant;
import com.plantit.dal.repositories.PlantRepository;
import com.plantit.dto.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Plant createPlant(Plant p) {
        return plantRepository.save(p);
    }
    public Plant savePlant(Plant p) { return plantRepository.save(p); };
    public Plant updatePlant(Plant p) { return plantRepository.save(p); };
    public void deletePlant(Plant p) { plantRepository.delete(p); };
    public void deletePlantById(Long id) { plantRepository.deleteById(id); };
    public Plant getPlant(Long id) { return plantRepository.findById(id).get(); };
    public List<Plant> getAllPlants() { return plantRepository.findAll(); };

}
