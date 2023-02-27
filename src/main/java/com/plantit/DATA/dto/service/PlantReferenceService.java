package com.plantit.dto.service;

import com.plantit.dal.entities.PlantReference;

import java.util.List;

public interface PlantReferenceService {

    PlantReference createPlantReference(PlantReference p);

    PlantReference savePlantReference(PlantReference p);

    PlantReference updatePlantReference(PlantReference p);

    void deletePlantReference(PlantReference p);

    void deletePlantReferenceById(Long id);

    PlantReference getPlantReference(Long id);

    List<PlantReference> getAllPlantReferences();

}
