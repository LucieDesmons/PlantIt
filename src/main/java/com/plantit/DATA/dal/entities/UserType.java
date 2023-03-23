package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.plantit.DATA.dto.AddressDTO;
import com.plantit.DATA.dto.UserTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Set<User> userCollection;


    /***** GETTER & SETTER *****/

    @JsonProperty("idUserType")
    public Long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Long idUserType) {
        this.idUserType = idUserType;
    }


    /***** CONSTRUCTOR *****/

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