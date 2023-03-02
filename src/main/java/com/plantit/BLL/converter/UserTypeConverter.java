package com.plantit.BLL.converter;

import com.plantit.DATA.dal.entities.UserHistoric;
import com.plantit.DATA.dal.entities.UserType;
import com.plantit.DATA.dto.UserHistoricDTO;
import com.plantit.DATA.dto.UserTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserTypeConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserTypeDTO convertEntityToDTO(UserType userType) {
        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));

        return modelMapper.map(userType, UserTypeDTO.class);
    }

    public UserType convertDtoToEntity(UserTypeDTO userTypeDTO) {

        return modelMapper.map(userTypeDTO, UserType.class);
    }

}