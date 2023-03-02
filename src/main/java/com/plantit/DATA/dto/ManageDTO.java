package com.plantit.DATA.dto;

import java.util.Date;

public class ManageDTO {

    private Long idManage;
    private UserDTO idUserCustomer;
    private UserDTO idUserBotanist;
    private Date startDate;
    private Date endDate;


    /***** GETTER & SETTER *****/

    public Long getIdManage() {
        return idManage;
    }

    public void setIdManage(Long idManage) {
        this.idManage = idManage;
    }

    public UserDTO getIdUserCustomer() {
        return idUserCustomer;
    }

    public void setIdUserCustomer(UserDTO idUserCustomer) {
        this.idUserCustomer = idUserCustomer;
    }

    public UserDTO getIdUserBotanist() {
        return idUserBotanist;
    }

    public void setIdUserBotanist(UserDTO idUserBotanist) {
        this.idUserBotanist = idUserBotanist;
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
