package com.plantit.dto;

import java.util.Date;
import java.util.Set;

public class PictureDTO {

    private Long idPictureDTO;
    private String way;
    private Date updateDate;
    private Set<MaintenanceDTO> maintenanceCollectionDTO;
    private Set<PlantDTO> plantCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdPictureDTO() {
        return idPictureDTO;
    }

    public void setIdPictureDTO(Long idPictureDTO) {
        this.idPictureDTO = idPictureDTO;
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

    public Set<MaintenanceDTO> getMaintenanceCollectionDTO() {
        return maintenanceCollectionDTO;
    }

    public void setMaintenanceCollectionDTO(Set<MaintenanceDTO> maintenanceCollectionDTO) {
        this.maintenanceCollectionDTO = maintenanceCollectionDTO;
    }

    public Set<PlantDTO> getPlantCollectionDTO() {
        return plantCollectionDTO;
    }

    public void setPlantCollectionDTO(Set<PlantDTO> plantCollectionDTO) {
        this.plantCollectionDTO = plantCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public PictureDTO() {
    }

}
