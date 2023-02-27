package com.plantit.dto;

import java.util.Date;
import java.util.Set;

public class PictureReferenceDTO {

    private Long idPictureReferenceDTO;
    private String way;
    private Date modificationDate;
    private Set<PlantReferenceDTO> plantReferenceCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdPictureReferenceDTO() {
        return idPictureReferenceDTO;
    }

    public void setIdPictureReferenceDTO(Long idPictureReferenceDTO) {
        this.idPictureReferenceDTO = idPictureReferenceDTO;
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

    public Set<PlantReferenceDTO> getPlantReferenceCollectionDTO() {
        return plantReferenceCollectionDTO;
    }

    public void setPlantReferenceCollectionDTO(Set<PlantReferenceDTO> plantReferenceCollectionDTO) {
        this.plantReferenceCollectionDTO = plantReferenceCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public PictureReferenceDTO() {
    }

}
