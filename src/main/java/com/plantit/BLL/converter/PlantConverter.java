package com.plantit.BLL.converter;

import com.plantit.DATA.dal.entities.Plant;
import com.plantit.DATA.dto.PlantDTO;
import com.plantit.DATA.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlantConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public PlantDTO convertEntityToDTO(Plant plant) {
        PlantDTO plantDTO = modelMapper.map(plant, PlantDTO.class);
        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));

        return plantDTO;
    }

    public Plant convertDtoToEntity(PlantDTO plantDTO) {
        Plant plant = modelMapper.map(plantDTO, Plant.class);

        return plant;
    }

}
