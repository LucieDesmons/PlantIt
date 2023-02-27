package com.plantit.dto;

import java.util.Date;

public class PasswordHistoricDTO {

    private Long idHistoricDTO;
    private String password;
    private Date updateDate;
    private UserDTO userDTO;


    /***** GETTER & SETTER *****/

    public Long getIdHistoricDTO() {
        return idHistoricDTO;
    }

    public void setIdHistoricDTO(Long idHistoricDTO) {
        this.idHistoricDTO = idHistoricDTO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


    /***** CONSTRUCTOR *****/

    public PasswordHistoricDTO() {
    }

}
