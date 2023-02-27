package com.plantit.dto;

import java.util.Set;

public class UserTypeDTO {

    private Long idUserTypeDTO;
    private String label;
    private Set<UserDTO> userCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdUserTypeDTO() {
        return idUserTypeDTO;
    }

    public void setIdUserTypeDTO(Long idUserTypeDTO) {
        this.idUserTypeDTO = idUserTypeDTO;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<UserDTO> getUserCollectionDTO() {
        return userCollectionDTO;
    }

    public void setUserCollectionDTO(Set<UserDTO> userCollectionDTO) {
        this.userCollectionDTO = userCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public UserTypeDTO() {
    }

}
