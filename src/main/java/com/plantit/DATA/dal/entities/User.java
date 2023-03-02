package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plantit.DATA.dto.UserDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {

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
    private String password;

    @Column(name = "degree")
    private String degree;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hobbies")
    private String hobbies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    private Address address;

    @ManyToOne
    @JoinColumn(name="id_godfather", nullable=true)
    private User godFather;

    @ManyToOne
    @JoinColumn(name="id_user_type", nullable=false)
    private UserType userType;


    /***** COLLECTION *****/

    @OneToMany(mappedBy="user1")
    private Set<Conversation> conversationCollection;

    @OneToMany(mappedBy="user")
    private Set<UserHistoric> userHistoricCollection;

    @OneToMany(mappedBy="user")
    private Set<PasswordHistoric> passwordHistoricCollection;

    @OneToMany(mappedBy="godFather")
    private Set<User> godFatherCollection;

    @ManyToMany(mappedBy="userCollection")
    private Set<Maintenance> maintenanceCollection;

    @OneToMany(mappedBy="user")
    private Set<CreatedBy> createdByCollection;

    @OneToMany(mappedBy="user")
    @JsonIgnoreProperties({"user"})
    @JsonBackReference
    private Set<Plant> plantCollection;


    /***** GETTER & SETTER *****/

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userType.getLabel()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public User(UserDTO userDTO){
        super();
        this.name = userDTO.getName();
        this.firstName = userDTO.getFirstName();
        this.phone = userDTO.getPhone();
        this.email = userDTO.getEmail();
        this.login = userDTO.getLogin();
        this.password = userDTO.getPassword();
        if (userDTO.getDegree() != null)
            this.degree = userDTO.getDegree();
        if (userDTO.getSpecialization() != null)
            this.specialization = userDTO.getSpecialization();
        this.hobbies = userDTO.getHobbies();
        // ref en boucle ça me rend fou
        //this.godFather = userDTO.getGodFatherDTO();
        this.address = new Address(userDTO.getAddressDTO());
        this.userType =  new UserType(userDTO.getUserTypeDTO());
    }

    public static User fromId(Long idUser) {
        User user = new User();
        user.idUser = idUser;
        return user;
    }

    /***** TO STRING *****/

    @Override
    public String toString() {
        return "User [name=" + name + ", firstName=" + firstName + ", phone=" + phone +
                "email=" + email + ", login=" + login + ", password=" + password +
                "degree=" + degree + ", specialization=" + specialization + ", hobbies=" + hobbies +
                "idGodfather=" + godFather.getIdUser() + ", address=" + address + ", userType=" + userType.getLabel() +"]";
    }

}