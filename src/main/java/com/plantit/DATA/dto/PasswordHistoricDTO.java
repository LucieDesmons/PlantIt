package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class PasswordHistoricDTO {

    private Long idHistoric;
    private String password;
    private Date updateDate;
    @JsonIgnore
    private UserDTO user;


    /***** GETTER & SETTER *****/

    public Long getIdHistoric() {
        return idHistoric;
    }

    public void setIdHistoric(Long idHistoric) {
        this.idHistoric = idHistoric;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    /***** CONSTRUCTOR *****/

    public PasswordHistoricDTO() {
    }

}
