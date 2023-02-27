package com.plantit.BLL;

import com.plantit.DATA.dal.entities.*;
import com.plantit.DATA.dal.repositories.AddressRepository;
import com.plantit.DATA.dal.repositories.UserRepository;
import com.plantit.DATA.dto.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static utility.Utility.END_DATE;

@Service
@Transactional
public class ManageUser {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public ManageUser(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public com.plantit.DATA.dal.entities.User createUser(com.plantit.DATA.dto.UserDTO userDTO) {

        User user = new com.plantit.DATA.dal.entities.User();
        user.setFirstName(userDTO.getFirstName());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setHobbies(userDTO.getHobbies());

        if (userDTO.getGodFatherDTO() != null) {
            User godFather = new User();
            godFather.setIdUser(userDTO.getGodFatherDTO().getIdUserDTO());
            user.setGodFather(godFather);
        }

        if (userDTO.getUserTypeDTO() != null) {
            UserType userType = new UserType();
            userType.setIdUserType(userDTO.getUserTypeDTO().getIdUserTypeDTO());
            user.setUserType(userType);
        }

        // Convert AddressDTO to Address
        AddressDTO addressDTO = new AddressDTO();
        Address address = new Address();
        address.setNumber(addressDTO.getNumber());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setWay(addressDTO.getWay());
        address.setAdditionalAddress(addressDTO.getAdditionalAddress());
        address.setTown(addressDTO.getTown());
        address = addressRepository.save(address);

        user.setAddress(address);

        // Convert UserHistoricDTO to UserHistoric and add to User
        UserHistoricDTO userHistoricDTO = new UserHistoricDTO();
        UserHistoric userHistoric = new UserHistoric();
        userHistoric.setStartDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        userHistoric.setEndDate(END_DATE);
        userHistoric.setUser(user);

        // Convert PasswordHistoricDTO to PasswordHistoric and add to User
        PasswordHistoricDTO passwordHistoricDTO = new PasswordHistoricDTO();
        PasswordHistoric passwordHistoric = new PasswordHistoric();
        passwordHistoric.setPassword(passwordHistoricDTO.getPassword());
        passwordHistoric.setUpdateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        passwordHistoric.setUser(user);

        return userRepository.save(user);

    }


    public void createCustomer(UserDTO userDTO) {
        UserTypeDTO userTypeDTO = new UserTypeDTO();
        userTypeDTO.setIdUserTypeDTO(UserDTO.CUSTUMER_ID);
        userDTO.setUserTypeDTO(userTypeDTO);
        createUser(userDTO);
    }


    public User createBotanist(UserDTO userDTO) {
        UserTypeDTO userTypeDTO = new UserTypeDTO();
        userTypeDTO.setIdUserTypeDTO(UserDTO.BOTANIST_ID);
        userDTO.setUserTypeDTO(userTypeDTO);

        User user = createUser(userDTO);

        user.setDegree(userDTO.getDegree());
        user.setSpecialization(userDTO.getSpecialization());

        return userRepository.save(user);
    }

    //change name commit
}
