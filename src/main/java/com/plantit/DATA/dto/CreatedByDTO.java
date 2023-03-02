package com.plantit.DATA.dto;

import java.util.Date;

public class CreatedByDTO {

    private Long idCreatedBy;
    private int orderNum;
    private Date updateDate;
    private PlantReferenceDTO plantReference;
    private UserDTO user;


    /***** GETTER & SETTER *****/

    public Long getIdCreatedBy() {
        return idCreatedBy;
    }

    public void setIdCreatedBy(Long idCreatedBy) {
        this.idCreatedBy = idCreatedBy;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public PlantReferenceDTO getPlantReference() {
        return plantReference;
    }

    public void setPlantReference(PlantReferenceDTO plantReference) {
        this.plantReference = plantReference;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    /***** CONSTRUCTOR *****/

    public CreatedByDTO() {
    }

}
