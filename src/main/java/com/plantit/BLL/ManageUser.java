package com.plantit.BLL;

import com.plantit.DATA.dal.entities.*;
import com.plantit.DATA.dal.repositories.AddressRepository;
import com.plantit.DATA.dal.repositories.UserRepository;
import com.plantit.DATA.dto.*;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO =  users.stream()
                .map((user) -> mapToUserDTO(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    private UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        // simple
        userDTO.setName(user.getName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setDegree(user.getDegree());
        userDTO.setSpecialization(user.getSpecialization());
        userDTO.setHobbies(user.getHobbies());

        //complex
        userDTO.setAddressDTO(mapToAddressDTO(user.getAddress()));

        userDTO.setUserTypeDTO(mapUserTypeToDTO(user.getUserType()));

        userDTO.setConversationCollectionDTO(user.getConversationCollection()
                .stream()
                .map( (conversation) -> mapToConversationDTO(conversation))
                .collect(Collectors.toSet()));

        userDTO.setUserHistoricCollectionDTO(user.getUserHistoricCollection()
                .stream()
                .map( (userHistoric) -> mapToUserHistoricDTO(userHistoric))
                .collect(Collectors.toSet()));

        userDTO.setPasswordHistoricCollectionDTO(user.getPasswordHistoricCollection()
                .stream()
                .map( (passwordHistoric) -> mapToPasswordHistoricDTO(passwordHistoric))
                .collect(Collectors.toSet()));

        // TODO: 28/02/2023 Ces foutus godfather
        // userDTO.setGodFatherDTO(user.getGodFather());

        userDTO.setMaintenanceCollectionDTO(user.getMaintenanceCollection()
                .stream()
                .map( (maintenance) -> mapToHMaintenanceDTO(maintenance))
                .collect(Collectors.toSet()));

        // TODO: 28/02/2023 CreatedBy

        userDTO.setPlantCollectionDTO(user.getPlantCollection()
                .stream()
                .map((plant) -> mapToPlantDTO(plant))
                .collect(Collectors.toSet()));

        return userDTO;
    }

    private AddressDTO mapToAddressDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setNumber(address.getNumber());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setWay(address.getWay());
        addressDTO.setAdditionalAddress(address.getAdditionalAddress());
        addressDTO.setTown(address.getTown());

        return addressDTO;
    }

    private UserTypeDTO mapUserTypeToDTO(UserType userType){
        UserTypeDTO userTypeDTO = new UserTypeDTO();

        userTypeDTO.setLabel(userTypeDTO.getLabel());

        return userTypeDTO;
    }

    private ConversationDTO mapToConversationDTO(Conversation conversation){
        ConversationDTO conversationDTO = new ConversationDTO();

        // TODO: 28/02/2023 conversion entity to DTO

        return conversationDTO;
    }

    private UserHistoricDTO mapToUserHistoricDTO(UserHistoric userHistoric){
        UserHistoricDTO userHistoricDTO = new UserHistoricDTO();

        // TODO: 28/02/2023 UserHistoric entity to DTO

        return userHistoricDTO;
    }

    private PasswordHistoricDTO mapToPasswordHistoricDTO(PasswordHistoric passwordHistoric){
        PasswordHistoricDTO passwordHistoricDTO = new PasswordHistoricDTO();

        passwordHistoricDTO.setPassword(passwordHistoric.getPassword());
        passwordHistoricDTO.setUpdateDate(passwordHistoric.getUpdateDate());
        // TODO: 28/02/2023 map le user en DTO mais comment ? car risque de boucle infini

        return passwordHistoricDTO;
    }

    private MaintenanceDTO mapToHMaintenanceDTO(Maintenance maintenance){
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();

        // TODO: 28/02/2023 La UserCollection encore et toujours

        maintenanceDTO.setPredictedDate(maintenance.getPredictedDate());
        maintenanceDTO.setRealizedDate(maintenance.getRealizedDate());
        maintenanceDTO.setReport(maintenanceDTO.getReport());
        maintenanceDTO.setPictureCollectionDTO(maintenance.getPictureCollection()
                .stream()
                .map((picture) -> mapToPictureDTO(picture))
                .collect(Collectors.toSet()));

        return maintenanceDTO;
    }

    private PlantDTO mapToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();

        plantDTO.setPlacePlant(plant.getPlacePlant());
        plantDTO.setContainer(plant.getContainer());
        plantDTO.setHumidity(plant.getHumidity());
        plantDTO.setClarity(plant.getClarity());

        // TODO: 28/02/2023 UserSet Classic comme d'hab

        plantDTO.setPictureCollectionDTO(plant.getPictureCollection()
                .stream()
                .map((picture) -> mapToPictureDTO(picture))
                .collect(Collectors.toSet()));

        plantDTO.setConversationCollectionDTO(plant.getConversationCollection()
                .stream()
                .map( (conversation) -> mapToConversationDTO(conversation))
                .collect(Collectors.toSet()));

        return plantDTO;
    }

    private PictureDTO mapToPictureDTO(Picture picture){
        PictureDTO pictureDTO = new PictureDTO();

        pictureDTO.setWay(picture.getWay());
        pictureDTO.setUpdateDate(picture.getUpdateDate());

        // MaintenanceCollection est déjà fait plus haut, dans lequel on map les picture, risque de boucle
        // PlantCollection est déjà fait plus haut, dans lequel on map les picture, risque de boucle

        return pictureDTO;
    }
}
