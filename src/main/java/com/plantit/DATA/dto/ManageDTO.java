package com.plantit.dto;

import java.util.Date;

public class ManageDTO {

    private Long idManageDTO;
    private UserDTO idUserCustomerDTO;
    private UserDTO idUserBotanistDTO;
    private Date startDate;
    private Date endDate;


    /***** GETTER & SETTER *****/

    public Long getIdManageDTO() {
        return idManageDTO;
    }

    public void setIdManageDTO(Long idManageDTO) {
        this.idManageDTO = idManageDTO;
    }

    public UserDTO getIdUserCustomerDTO() {
        return idUserCustomerDTO;
    }

    public void setIdUserCustomerDTO(UserDTO idUserCustomerDTO) {
        this.idUserCustomerDTO = idUserCustomerDTO;
    }

    public UserDTO getIdUserBotanistDTO() {
        return idUserBotanistDTO;
    }

    public void setIdUserBotanistDTO(UserDTO idUserBotanistDTO) {
        this.idUserBotanistDTO = idUserBotanistDTO;
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


    /***** CONSTRUCTOR *****/

    public ManageDTO() {
    }

}
