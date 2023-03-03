package com.plantit.BLL;

import com.plantit.BLL.converter.PlantReferenceConverter;
import com.plantit.DATA.dal.entities.PlantReference;
import com.plantit.DATA.dal.repositories.PlantReferenceRepository;
import com.plantit.DATA.dto.PlantReferenceDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManagePlantReference {
    private final PlantReferenceRepository repository;

    private final PlantReferenceConverter plantReferenceConverter;

    public ManagePlantReference(PlantReferenceRepository repository, PlantReferenceConverter plantReferenceConverter) {
        this.repository = repository;
        this.plantReferenceConverter = plantReferenceConverter;
    }

    public PlantReferenceDTO createPlantReference(PlantReferenceDTO plantReferenceDTO){

        PlantReference plantReference = plantReferenceConverter.convertDtoToEntity(plantReferenceDTO);

        plantReference = repository.save(plantReference);

        plantReferenceDTO =  plantReferenceConverter.convertEntityToDTO(plantReference);

        plantReferenceDTO.setIdPlantReference(plantReference.getIdPlantReference());


        return plantReferenceDTO;
    }

    public List<PlantReferenceDTO> getPlantReferences() {
        return repository.findAll().stream()
                .map((plantRef) -> plantReferenceConverter.convertEntityToDTO(plantRef))
                .collect(Collectors.toList());
    }

    public Optional<PlantReferenceDTO> getPlantReferenceById(long id) {
        Optional<PlantReference> existing = repository.findById(id);

        if (existing.isPresent()){
            PlantReferenceDTO dto = plantReferenceConverter.convertEntityToDTO(existing.get());

            return Optional.ofNullable(dto);
        }
        else return Optional.empty();
    }

    public void deletePlantReference(long id) {
        Optional<PlantReference> existing = repository.findById(id);
        if (existing.isPresent()){
            repository.delete(existing.get());
        }
        else throw  new NotFoundException("La référence de plante que vous essayez de supprimer n'éxiste pas");
    }


}
