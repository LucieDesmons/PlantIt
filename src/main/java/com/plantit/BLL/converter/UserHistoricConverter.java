package com.plantit.BLL.converter;

import com.plantit.DATA.dal.entities.UserHistoric;
import com.plantit.DATA.dto.UserHistoricDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserHistoricConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserHistoricDTO convertEntityToDTO(UserHistoric userHistoric) {
        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));

        return modelMapper.map(userHistoric, UserHistoricDTO.class);
    }

    public UserHistoric convertDtoToEntity(UserHistoricDTO userHistoricDTO) {

        return modelMapper.map(userHistoricDTO, UserHistoric.class);
    }

}