package com.plantit.BLL;

import com.plantit.DATA.dal.entities.PlantReference;
import com.plantit.DATA.dal.repositories.PlantReferenceRepository;
import com.plantit.DATA.dto.PlantReferenceDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManagePlantReference {
    private final PlantReferenceRepository repository;

    public ManagePlantReference(PlantReferenceRepository repository) {
        this.repository = repository;
    }

    public PlantReference createPlantReference(PlantReferenceDTO plantReferenceDTO){
        return repository.save(new PlantReference(plantReferenceDTO));
    }
}
