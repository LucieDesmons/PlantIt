package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class UserTypeDTO {

    private Long idUserType;
    private String label;
    @JsonIgnore
    private Set<UserDTO> userCollection;


    /***** GETTER & SETTER *****/

    @JsonProperty("id_user_type")
    public Long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Long idUserType) {
        this.idUserType = idUserType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<UserDTO> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Set<UserDTO> userCollection) {
        this.userCollection = userCollection;
    }


    /***** CONSTRUCTOR *****/

    public UserTypeDTO() {
    }

}
