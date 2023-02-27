package com.plantit.dto;

import java.util.Date;

public class UserHistoricDTO {

    private Long idUserHistoricDTO;
    private Date startDate;
    private Date endDate;
    private UserDTO userDTO;


    /***** GETTER & SETTER *****/

    public Long getIdUserHistoricDTO() {
        return idUserHistoricDTO;
    }

    public void setIdUserHistoricDTO(Long idUserHistoricDTO) {
        this.idUserHistoricDTO = idUserHistoricDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


    /***** CONSTRUCTOR *****/

    public UserHistoricDTO() {
    }

}
