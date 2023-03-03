package com.plantit.BLL.converter;


import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO convertEntityToDTO(User user) {
        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));

        return modelMapper.map(user, UserDTO.class);
    }

    public User convertDtoToEntity(UserDTO userDTO) {

        return modelMapper.map(userDTO, User.class);
    }

}
