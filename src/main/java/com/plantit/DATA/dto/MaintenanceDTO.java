package com.plantit.DATA.dto;

import java.util.Date;
import java.util.Set;

public class MaintenanceDTO {

    private Long idMaintenance;
    private Date predictedDate;
    private Date realizedDate;
    private String report;
    private Set<PictureDTO> pictureCollection;
    private Set<UserDTO> userCollection;


    /***** GETTER & SETTER *****/

    public Long getIdMaintenance() {
        return idMaintenance;
    }

    public void setIdMaintenance(Long idMaintenance) {
        this.idMaintenance = idMaintenance;
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

    public Set<PictureDTO> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Set<PictureDTO> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    public Set<UserDTO> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Set<UserDTO> userCollection) {
        this.userCollection = userCollection;
    }


    /***** CONSTRUCTOR *****/

    public MaintenanceDTO() {
    }

}
