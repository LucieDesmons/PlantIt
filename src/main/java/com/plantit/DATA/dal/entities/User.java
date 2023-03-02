package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.*;
import com.plantit.DATA.dto.UserDTO;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "degree")
    private String degree;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hobbies")
    private String hobbies;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_address")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("id_address")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_godfather")
    private User godFather;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user_type")
    @JsonIgnore
    private UserType userType;


    /***** COLLECTION *****/

    @OneToMany(mappedBy="user1", fetch = FetchType.LAZY)
    private Set<Conversation> conversationCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<UserHistoric> userHistoricCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<PasswordHistoric> passwordHistoricCollection;

    @OneToMany(mappedBy="godFather", fetch = FetchType.LAZY)
    private Set<User> godFatherCollection;

    @ManyToMany(mappedBy="userCollection", fetch = FetchType.LAZY)
    private Set<Maintenance> maintenanceCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<CreatedBy> createdByCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<Plant> plantCollection;


    /***** GETTER & SETTER *****/

    @JsonProperty("idUser")
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

/*    @JsonProperty("idAddress")
    public void setAddressById(Long idAddress) {
        address = Address.fromId(idAddress, address);
    }*/

    public User getGodFather() {
        return godFather;
    }

    public void setGodFather(User godFather) {
        this.godFather = godFather;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @JsonProperty("idUserType")
    public void setUserTypeById(Long idUserType) {
        userType = UserType.fromId(idUserType);
    }

    public Set<Conversation> getConversationCollection() {
        return conversationCollection;
    }

    public void setConversationCollection(Set<Conversation> conversationCollection) {
        this.conversationCollection = conversationCollection;
    }

    public Set<UserHistoric> getUserHistoricCollection() {
        return userHistoricCollection;
    }

    public void setUserHistoricCollection(Set<UserHistoric> userHistoricCollection) {
        this.userHistoricCollection = userHistoricCollection;
    }

    public Set<PasswordHistoric> getPasswordHistoricCollection() {
        return passwordHistoricCollection;
    }

    public void setPasswordHistoricCollection(Set<PasswordHistoric> passwordHistoricCollection) {
        this.passwordHistoricCollection = passwordHistoricCollection;
    }

    public Set<User> getGodFatherCollection() {
        return godFatherCollection;
    }

    public void setGodFatherCollection(Set<User> godFatherCollection) {
        this.godFatherCollection = godFatherCollection;
    }

    public Set<Maintenance> getMaintenanceCollection() {
        return maintenanceCollection;
    }

    public void setMaintenanceCollection(Set<Maintenance> maintenanceCollection) {
        this.maintenanceCollection = maintenanceCollection;
    }

    public Set<CreatedBy> getCreatedByCollection() {
        return createdByCollection;
    }

    public void setCreatedByCollection(Set<CreatedBy> createdByCollection) {
        this.createdByCollection = createdByCollection;
    }

    public Set<Plant> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<Plant> plantCollection) {
        this.plantCollection = plantCollection;
    }


    /***** CONSTRUCTOR *****/

    public User() {

    }

    public User(String name, String firstName, String phone, String email, String login, String password, String degree,
                String specialization, String hobbies, User godFather, Address address, UserType userType) {
        super();
        this.name = name;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.degree = degree;
        this.specialization = specialization;
        this.hobbies = hobbies;
        this.godFather = godFather;
        this.address = address;
        this.userType = userType;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", address=" + address +
                ", userType=" + userType +
                ", godFather=" + (godFather == null ? null : godFather.getIdUser()) + // Utilisation d'une expression ternaire pour éviter de l'appeler si godFather est nul
                ", degree='" + degree + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

}