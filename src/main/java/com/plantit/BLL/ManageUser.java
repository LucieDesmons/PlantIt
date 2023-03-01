package com.plantit.BLL;

import com.plantit.DATA.dal.entities.*;
import com.plantit.DATA.dal.repositories.AddressRepository;
import com.plantit.DATA.dal.repositories.PasswordHistoricRepository;
import com.plantit.DATA.dal.repositories.UserHistoricRepository;
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
    private final UserHistoricRepository userHistoricRepository;
    private final PasswordHistoricRepository passwordHistoricRepository;

    public ManageUser(AddressRepository addressRepository, UserRepository userRepository,
                      UserHistoricRepository userHistoricRepository,
                      PasswordHistoricRepository passwordHistoricRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.userHistoricRepository = userHistoricRepository;
        this.passwordHistoricRepository = passwordHistoricRepository;
    }

    public User createUser(UserDTO userDTO) {

        User user = new User();
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
        Address address = new Address();
        address.setNumber(userDTO.getAddressDTO().getNumber());
        address.setPostalCode(userDTO.getAddressDTO().getPostalCode());
        address.setWay(userDTO.getAddressDTO().getWay());
        address.setAdditionalAddress(userDTO.getAddressDTO().getAdditionalAddress());
        address.setTown(userDTO.getAddressDTO().getTown());
        address = addressRepository.save(address);

        user.setAddress(address);

        user = userRepository.save(user);

        // Convert UserHistoricDTO to UserHistoric and add to User
        UserHistoric userHistoric = new UserHistoric();
        userHistoric.setUser(user);
        userHistoric.setStartDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        userHistoric.setEndDate(END_DATE);
        userHistoricRepository.save(userHistoric);

        // Convert PasswordHistoricDTO to PasswordHistoric and add to User
        PasswordHistoricDTO passwordHistoricDTO = new PasswordHistoricDTO();
        PasswordHistoric passwordHistoric = new PasswordHistoric();
        passwordHistoric.setUser(user);
        passwordHistoric.setPassword(userDTO.getPassword());
        passwordHistoric.setUpdateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        passwordHistoricRepository.save(passwordHistoric);

        return user;

    }

    public User createCustomer(UserDTO userDTO) {
        UserTypeDTO userTypeDTO = new UserTypeDTO();
        userTypeDTO.setIdUserTypeDTO(UserDTO.CUSTUMER_ID);
        userDTO.setUserTypeDTO(userTypeDTO);
        createUser(userDTO);

        User user = createUser(userDTO);

        return userRepository.save(user);
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

   /* public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        // Update the user information
        user.setName(userDTO.getName());
        user.setFirstName(userDTO.getFirstName());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setDegree(userDTO.getDegree());
        user.setSpecialization(userDTO.getSpecialization());
        //user.setGodFather(userDTO.getG());
        //user.setAddress(userDTO.getAddresse());
       // user.setUserType(userDTO.getUserTypeDTO());

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUsersByType(Type type) {
        return userRepository.findByType(type);
    }*/

}
