package com.plantit.dto;

import java.util.Date;
import java.util.Set;

public class MaintenanceDTO {

    private Long idMaintenanceDTO;
    private Date predictedDate;
    private Date realizedDate;
    private String report;
    private Set<PictureDTO> pictureCollectionDTO;
    private Set<UserDTO> userCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdMaintenanceDTO() {
        return idMaintenanceDTO;
    }

    public void setIdMaintenanceDTO(Long idMaintenanceDTO) {
        this.idMaintenanceDTO = idMaintenanceDTO;
    }

    public Date getPredictedDate() {
        return predictedDate;
    }

    public void setPredictedDate(Date predictedDate) {
        this.predictedDate = predictedDate;
    }

    public Date getRealizedDate() {
        return realizedDate;
    }

    public void setRealizedDate(Date realizedDate) {
        this.realizedDate = realizedDate;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Set<PictureDTO> getPictureCollectionDTO() {
        return pictureCollectionDTO;
    }

    public void setPictureCollectionDTO(Set<PictureDTO> pictureCollectionDTO) {
        this.pictureCollectionDTO = pictureCollectionDTO;
    }

    public Set<UserDTO> getUserCollectionDTO() {
        return userCollectionDTO;
    }

    public void setUserCollectionDTO(Set<UserDTO> userCollectionDTO) {
        this.userCollectionDTO = userCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public MaintenanceDTO() {
    }

}
