package com.plantit.DATA.dto;

import java.util.Date;
import java.util.Set;

public class PictureDTO {

    private Long idPicture;
    private String way;
    private Date updateDate;
    private Set<MaintenanceDTO> maintenanceCollection;
    private Set<PlantDTO> plantCollection;


    /***** GETTER & SETTER *****/

    public Long getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(Long idPicture) {
        this.idPicture = idPicture;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<MaintenanceDTO> getMaintenanceCollection() {
        return maintenanceCollection;
    }

    public void setMaintenanceCollection(Set<MaintenanceDTO> maintenanceCollection) {
        this.maintenanceCollection = maintenanceCollection;
    }

    public Set<PlantDTO> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<PlantDTO> plantCollection) {
        this.plantCollection = plantCollection;
    }


    /***** CONSTRUCTOR *****/

    public PictureDTO() {
    }

}
