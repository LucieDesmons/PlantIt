package com.plantit.dto;

import java.util.Date;
import java.util.Set;

public class UserDTO {

    public static final Long ADMIN_ID = 1L;
    public static final Long BOTANIST_ID = 2L;
    public static final Long CUSTUMER_ID = 3L;

    private Long idUserDTO;
    private String name;
    private String firstName;
    private String phone;
    private String email;
    private String login;
    private String password;
    private String degree;
    private String specialization;
    private String hobbies;
    private AddressDTO addressDTO;
    private UserDTO godFatherDTO;
    private UserTypeDTO userTypeDTO;
    private Set<ConversationDTO> conversationCollectionDTO;
    private Set<UserHistoricDTO> userHistoricCollectionDTO;
    private Set<PasswordHistoricDTO> passwordHistoricCollectionDTO;
    private Set<UserDTO> godFatherCollectionDTO;
    private Set<MaintenanceDTO> maintenanceCollectionDTO;
    private Set<CreatedByDTO> createdByCollectionDTO;
    private Set<PlantDTO> plantCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdUserDTO() {
        return idUserDTO;
    }

    public void setIdUserDTO(Long idUserDTO) {
        this.idUserDTO = idUserDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public UserDTO getGodFatherDTO() {
        return godFatherDTO;
    }

    public void setGodFatherDTO(UserDTO godFatherDTO) {
        this.godFatherDTO = godFatherDTO;
    }

    public UserTypeDTO getUserTypeDTO() {
        return userTypeDTO;
    }

    public void setUserTypeDTO(UserTypeDTO userTypeDTO) {
        this.userTypeDTO = userTypeDTO;
    }

    public Set<ConversationDTO> getConversationCollectionDTO() {
        return conversationCollectionDTO;
    }

    public void setConversationCollectionDTO(Set<ConversationDTO> conversationCollectionDTO) {
        this.conversationCollectionDTO = conversationCollectionDTO;
    }

    public Set<UserHistoricDTO> getUserHistoricCollectionDTO() {
        return userHistoricCollectionDTO;
    }

    public void setUserHistoricCollectionDTO(Set<UserHistoricDTO> userHistoricCollectionDTO) {
        this.userHistoricCollectionDTO = userHistoricCollectionDTO;
    }

    public Set<PasswordHistoricDTO> getPasswordHistoricCollectionDTO() {
        return passwordHistoricCollectionDTO;
    }

    public void setPasswordHistoricCollectionDTO(Set<PasswordHistoricDTO> passwordHistoricCollectionDTO) {
        this.passwordHistoricCollectionDTO = passwordHistoricCollectionDTO;
    }

    public Set<UserDTO> getGodFatherCollectionDTO() {
        return godFatherCollectionDTO;
    }

    public void setGodFatherCollectionDTO(Set<UserDTO> godFatherCollectionDTO) {
        this.godFatherCollectionDTO = godFatherCollectionDTO;
    }

    public Set<MaintenanceDTO> getMaintenanceCollectionDTO() {
        return maintenanceCollectionDTO;
    }

    public void setMaintenanceCollectionDTO(Set<MaintenanceDTO> maintenanceCollectionDTO) {
        this.maintenanceCollectionDTO = maintenanceCollectionDTO;
    }

    public Set<CreatedByDTO> getCreatedByCollectionDTO() {
        return createdByCollectionDTO;
    }

    public void setCreatedByCollectionDTO(Set<CreatedByDTO> createdByCollectionDTO) {
        this.createdByCollectionDTO = createdByCollectionDTO;
    }

    public Set<PlantDTO> getPlantCollectionDTO() {
        return plantCollectionDTO;
    }

    public void setPlantCollectionDTO(Set<PlantDTO> plantCollectionDTO) {
        this.plantCollectionDTO = plantCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public UserDTO() {
    }

}
