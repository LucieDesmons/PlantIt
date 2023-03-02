package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class UserHistoricDTO {

    private Long idUserHistoric;
    private Date startDate;
    private Date endDate;
    @JsonIgnore
    private UserDTO user;


    /***** GETTER & SETTER *****/

    public Long getIdUserHistoric() {
        return idUserHistoric;
    }

    public void setIdUserHistoric(Long idUserHistoric) {
        this.idUserHistoric = idUserHistoric;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    /***** CONSTRUCTOR *****/

    public UserHistoricDTO() {
    }

}
