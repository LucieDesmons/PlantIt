package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.plantit.DATA.dto.AddressDTO;
import com.plantit.DATA.dto.UserTypeDTO;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_type")
    private Long idUserType;

    @Column(name = "label")
    private String label;


    /***** COLLECTION *****/

    @OneToMany(mappedBy="userType")
    @JsonIgnoreProperties("userType")
    @JsonIgnore
    private Set<User> userCollection;


    /***** GETTER & SETTER *****/

    @JsonProperty("idUserType")
    public Long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Long idUserType) {
        this.idUserType = idUserType;
    }

    public static UserType fromId(Long idUserType) {
        UserType userType = new UserType();
        userType.idUserType = idUserType;
        return userType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Set<User> userCollection) {
        this.userCollection = userCollection;
    }


    /***** CONSTRUCTOR *****/

    public UserType() {

    }

    public UserType(String label) {
        super();
        this.label = label;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "UserType [label=" + label + "]";
    }

}