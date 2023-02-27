package com.plantit.dto;

import java.util.Date;

public class CreatedByDTO {

    private Long idCreatedByDTO;
    private int orderNum;
    private Date updateDate;
    private PlantReferenceDTO plantReferenceDTO;
    private UserDTO userDTO;


    /***** GETTER & SETTER *****/

    public Long getIdCreatedByDTO() {
        return idCreatedByDTO;
    }

    public void setIdCreatedByDTO(Long idCreatedByDTO) {
        this.idCreatedByDTO = idCreatedByDTO;
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

    public PlantReferenceDTO getPlantReferenceDTO() {
        return plantReferenceDTO;
    }

    public void setPlantReferenceDTO(PlantReferenceDTO plantReferenceDTO) {
        this.plantReferenceDTO = plantReferenceDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


    /***** CONSTRUCTOR *****/

    public CreatedByDTO() {
    }

}
