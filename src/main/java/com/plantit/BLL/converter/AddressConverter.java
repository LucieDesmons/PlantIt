package com.plantit.BLL.converter;

import com.plantit.DATA.dal.entities.Address;
import com.plantit.DATA.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public AddressDTO convertEntityToDTO(Address address) {
        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));

        return modelMapper.map(address, AddressDTO.class);
    }

    public Address convertDtoToEntity(AddressDTO addressDTO) {

        return modelMapper.map(addressDTO, Address.class);
    }

}
