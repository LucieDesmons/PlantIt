package com.plantit.dto.service.impl;

import com.plantit.dal.entities.PlantReference;
import com.plantit.dal.repositories.PlantReferenceRepository;
import com.plantit.dto.service.PlantReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantReferenceServiceImpl implements PlantReferenceService {

    @Autowired
    PlantReferenceRepository plantReferenceRepository;

    public PlantReference createPlantReference(PlantReference p) {
        return plantReferenceRepository.save(p);
    }
    public PlantReference savePlantReference(PlantReference p) { return plantReferenceRepository.save(p); };
    public PlantReference updatePlantReference(PlantReference p) { return plantReferenceRepository.save(p); };
    public void deletePlantReference(PlantReference p) { plantReferenceRepository.delete(p); };
    public void deletePlantReferenceById(Long id) { plantReferenceRepository.deleteById(id); };
    public PlantReference getPlantReference(Long id) { return plantReferenceRepository.findById(id).get(); };
    public List<PlantReference> getAllPlantReferences() { return plantReferenceRepository.findAll(); };

}
