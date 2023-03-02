package com.plantit.DATA.dto;

import java.util.Date;
import java.util.Set;

public class PictureReferenceDTO {

    private Long idPictureReference;
    private String way;
    private Date modificationDate;
    private Set<PlantReferenceDTO> plantReferenceCollection;


    /***** GETTER & SETTER *****/

    public Long getIdPictureReference() {
        return idPictureReference;
    }

    public void setIdPictureReference(Long idPictureReference) {
        this.idPictureReference = idPictureReference;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Set<PlantReferenceDTO> getPlantReferenceCollection() {
        return plantReferenceCollection;
    }

    public void setPlantReferenceCollection(Set<PlantReferenceDTO> plantReferenceCollection) {
        this.plantReferenceCollection = plantReferenceCollection;
    }


    /***** CONSTRUCTOR *****/

    public PictureReferenceDTO() {
    }

}
