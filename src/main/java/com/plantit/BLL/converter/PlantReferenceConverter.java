package com.plantit.BLL.converter;

import com.plantit.DATA.dal.entities.Plant;
import com.plantit.DATA.dal.entities.PlantReference;
import com.plantit.DATA.dto.PlantDTO;
import com.plantit.DATA.dto.PlantReferenceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlantReferenceConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public PlantReferenceDTO convertEntityToDTO(PlantReference plantReference){

        return modelMapper.map(plantReference, PlantReferenceDTO.class);
    }

    public PlantReference convertDtoToEntity(PlantReferenceDTO plantDTO) {

        return modelMapper.map(plantDTO, PlantReference.class);
    }

}


// private final ModelMapper modelMapper = new ModelMapper();
//
//    public PlantReferenceDTO convertEntityToDTO(PlantReference plant) {
//        PlantReferenceDTO plantDTO = modelMapper.map(plant, PlantReferenceDTO.class);
//        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));
//
//        return plantDTO;
//    }
//
//    public PlantReference convertDtoToEntity(PlantReferenceDTO plantDTO) {
//        PlantReference plant = modelMapper.map(plantDTO, PlantReference.class);
//
//        return plant;
//    }