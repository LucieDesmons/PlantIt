package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.plantit.DATA.dal.entities.Address;

import java.util.Date;
import java.util.Set;

public class UserDTO {

    public static final Long ADMIN_ID = 1L;
    public static final Long BOTANIST_ID = 2L;
    public static final Long CUSTUMER_ID = 3L;

    private Long idUser;
    private String name;
    private String firstName;
    private String phone;
    private String email;
    private String login;
    private String password;
    private String degree;
    private String specialization;
    private String hobbies;
    private AddressDTO address;
    private UserDTO godFather;
    @JsonIgnore
    private UserTypeDTO userType;
    private Set<ConversationDTO> conversationCollection;
    private Set<UserHistoricDTO> userHistoricCollection;
    private Set<PasswordHistoricDTO> passwordHistoricCollection;
    private Set<UserDTO> godFatherCollection;
    private Set<MaintenanceDTO> maintenanceCollection;
    private Set<CreatedByDTO> createdByCollection;
    private Set<PlantDTO> plantCollection;


    /***** GETTER & SETTER *****/

    @JsonProperty("id_user")
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public UserDTO getGodFather() {
        return godFather;
    }

    public void setGodFather(UserDTO godFather) {
        this.godFather = godFather;
    }

    public UserTypeDTO getUserType() {
        return userType;
    }

    public void setUserType(UserTypeDTO userType) {
        this.userType = userType;
    }

    public Set<ConversationDTO> getConversationCollection() {
        return conversationCollection;
    }

    public void setConversationCollection(Set<ConversationDTO> conversationCollection) {
        this.conversationCollection = conversationCollection;
    }

    public Set<UserHistoricDTO> getUserHistoricCollection() {
        return userHistoricCollection;
    }

    public void setUserHistoricCollection(Set<UserHistoricDTO> userHistoricCollection) {
        this.userHistoricCollection = userHistoricCollection;
    }

    public Set<PasswordHistoricDTO> getPasswordHistoricCollection() {
        return passwordHistoricCollection;
    }

    public void setPasswordHistoricCollection(Set<PasswordHistoricDTO> passwordHistoricCollection) {
        this.passwordHistoricCollection = passwordHistoricCollection;
    }

    public Set<UserDTO> getGodFatherCollection() {
        return godFatherCollection;
    }

    public void setGodFatherCollection(Set<UserDTO> godFatherCollection) {
        this.godFatherCollection = godFatherCollection;
    }

    public Set<MaintenanceDTO> getMaintenanceCollection() {
        return maintenanceCollection;
    }

    public void setMaintenanceCollection(Set<MaintenanceDTO> maintenanceCollection) {
        this.maintenanceCollection = maintenanceCollection;
    }

    public Set<CreatedByDTO> getCreatedByCollection() {
        return createdByCollection;
    }

    public void setCreatedByCollection(Set<CreatedByDTO> createdByCollection) {
        this.createdByCollection = createdByCollection;
    }

    public Set<PlantDTO> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<PlantDTO> plantCollection) {
        this.plantCollection = plantCollection;
    }


    /***** CONSTRUCTOR *****/

    public UserDTO() {
    }

}
