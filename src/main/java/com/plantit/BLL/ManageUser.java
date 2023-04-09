package com.plantit.BLL;

import com.plantit.BLL.converter.*;
import com.plantit.DATA.dal.entities.*;
import com.plantit.DATA.dal.repositories.*;
import com.plantit.DATA.dto.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static utility.Utility.END_DATE;

@Service
@Transactional
public class ManageUser {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserHistoricRepository userHistoricRepository;
    private final PasswordHistoricRepository passwordHistoricRepository;
    private final UserConverter userConverter;
    private final AddressConverter addressConverter;
    private final UserTypeRepository userTypeRepository;
    private final UserTypeConverter userTypeConverter;

    public ManageUser(AddressRepository addressRepository, UserRepository userRepository,
                      UserHistoricRepository userHistoricRepository,
                      PasswordHistoricRepository passwordHistoricRepository,
                      UserConverter userConverter, AddressConverter addressConverter,
                      UserTypeRepository userTypeRepository, UserTypeConverter userTypeConverter) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.userHistoricRepository = userHistoricRepository;
        this.passwordHistoricRepository = passwordHistoricRepository;
        this.userConverter = userConverter;
        this.addressConverter = addressConverter;
        this.userTypeRepository = userTypeRepository;
        this.userTypeConverter = userTypeConverter;
    }

    public User createUser(UserDTO userDTO) {

        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setHobbies(userDTO.getHobbies());

        if (userDTO.getGodFather() != null) {
            User godFather = userRepository.findById(userDTO.getGodFather().getIdUser())
                    .orElseThrow(() -> new EntityNotFoundException("GodFather not found with id: " + userDTO.getGodFather().getIdUser()));
            user.setGodFather(godFather);
        } else {
            user.setGodFather(null);
        }

        if (userDTO.getUserType() != null) {
            UserType userType = new UserType();
            userType.setIdUserType(userDTO.getUserType().getIdUserType());
            user.setUserType(userType);
        }

        // Convert AddressDTO to Address
        Address address = new Address();
        address.setNumber(userDTO.getAddress().getNumber());
        address.setPostalCode(userDTO.getAddress().getPostalCode());
        address.setWay(userDTO.getAddress().getWay());
        address.setAdditionalAddress(userDTO.getAddress().getAdditionalAddress());
        address.setTown(userDTO.getAddress().getTown());
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
        userTypeDTO.setIdUserType(UserDTO.CUSTUMER_ID);
        userDTO.setUserType(userTypeDTO);
        createUser(userDTO);

        User user = createUser(userDTO);

        return userRepository.save(user);
    }

    public User createBotanist(UserDTO userDTO) {
        UserTypeDTO userTypeDTO = new UserTypeDTO();
        userTypeDTO.setIdUserType(UserDTO.BOTANIST_ID);
        userDTO.setUserType(userTypeDTO);

        User user = createUser(userDTO);

        user.setDegree(userDTO.getDegree());
        user.setSpecialization(userDTO.getSpecialization());

        return userRepository.save(user);
    }

    public UserDTO getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            UserDTO userDTO = userConverter.convertEntityToDTO(user.get());

            // Charger l'adresse à partir de la base de données
            Long addressId = user.get().getAddress().getIdAddress();
            Optional<Address> address = addressRepository.findById(addressId);
            if (address.isPresent()) {
                AddressDTO addressDTO = addressConverter.convertEntityToDTO(address.get());
                userDTO.setAddress(addressDTO);
            }

            // Charger le type à partir de la base de données
            Long userTypeId = user.get().getUserType().getIdUserType();
            Optional<UserType> userType = userTypeRepository.findById(userTypeId);
            if (userType.isPresent()) {
                UserTypeDTO userTypeDTO = userTypeConverter.convertEntityToDTO(userType.get());
                userDTO.setUserType(userTypeDTO);
            }

            return userDTO;
        }
        return null;
    }

    public UserDTO Login(String login, String password) {
        Optional<User> user = userRepository.findByEmail(login);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return getUserById(user.get().getIdUser());
            }
        }
        throw new EntityNotFoundException("User not found with login: " + login);
    }

    public List<UserDTO> getAllUsers() {

        return userRepository.findAll().stream()
                .map((user) -> userConverter.convertEntityToDTO(user))
                .collect(Collectors.toList());
    }

    public User updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setHobbies(userDTO.getHobbies());

        if (userDTO.getGodFather() != null) {
            User godFather = userRepository.findById(userDTO.getGodFather().getIdUser())
                    .orElseThrow(() -> new EntityNotFoundException("GodFather not found with id: " + userDTO.getGodFather().getIdUser()));
            user.setGodFather(godFather);
        }

        if (userDTO.getAddress() != null) {
            Address address = addressRepository.findById(userDTO.getAddress().getIdAddress())
                    .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + userDTO.getAddress().getIdAddress()));
            address.setNumber(userDTO.getAddress().getNumber());
            address.setPostalCode(userDTO.getAddress().getPostalCode());
            address.setWay(userDTO.getAddress().getWay());
            address.setAdditionalAddress(userDTO.getAddress().getAdditionalAddress());
            address.setTown(userDTO.getAddress().getTown());
            address = addressRepository.save(address);

            user.setAddress(address);
        }

        if (userDTO.getUserType() != null) {
            UserType userType = userTypeRepository.findById(userDTO.getUserType().getIdUserType())
                    .orElseThrow(() -> new EntityNotFoundException("UserType not found with id: " + userDTO.getUserType().getIdUserType()));
            userType.setIdUserType(userDTO.getUserType().getIdUserType());
            user.setUserType(userType);
        }

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            // Supprimer les enregistrements d'historique de mot de passe associés à l'utilisateur
            Set<PasswordHistoric> passwordHistoricSet = user.get().getPasswordHistoricCollection();
            for (PasswordHistoric passwordHistoric : passwordHistoricSet) {
                passwordHistoricRepository.delete(passwordHistoric);
            }

            // Supprimer les enregistrements d'utilisateur de mot de passe associés à l'utilisateur
            Set<UserHistoric> userHistoricSet = user.get().getUserHistoricCollection();
            for (UserHistoric userHistoric : userHistoricSet) {
                userHistoricRepository.delete(userHistoric);
            }

            // Supprimer l'utilisateur
            userRepository.delete(user.get());
        } else {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }
    }

    public List<UserDTO> getUsersByType(Long userTypeId) {
        UserType userType = userTypeRepository.findById(userTypeId)
                .orElseThrow(() -> new EntityNotFoundException("UserType not found with id: " + userTypeId));
        return userRepository.findByUserType(userType)
                .stream().map((user) -> userConverter.convertEntityToDTO(user))
                .collect(Collectors.toList());
    }

}
