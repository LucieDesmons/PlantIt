package com.plantit.dto;

import java.util.Set;

public class PlantReferenceDTO {

    private Long idPlantReferenceDTO;
    private String family;
    private int size;
    private String foodSource;
    private String reproduction;
    private int lifetime;
    private String placeLife;
    private Set<CreatedByDTO> createdByCollectionDTO;
    private Set<PlantDTO> plantCollectionDTO;
    private Set<PictureReferenceDTO> pictureReferenceCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdPlantReferenceDTO() {
        return idPlantReferenceDTO;
    }

    public void setIdPlantReferenceDTO(Long idPlantReferenceDTO) {
        this.idPlantReferenceDTO = idPlantReferenceDTO;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFoodSource() {
        return foodSource;
    }

    public void setFoodSource(String foodSource) {
        this.foodSource = foodSource;
    }

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public String getPlaceLife() {
        return placeLife;
    }

    public void setPlaceLife(String placeLife) {
        this.placeLife = placeLife;
    }

    public Set<CreatedByDTO> getCreatedByCollectionDTO() {
        return createdByCollectionDTO;
    }

    public void setCreatedByCollectionDTO(Set<CreatedByDTO> createdByCollectionDTO) {
        this.createdByCollectionDTO = createdByCollectionDTO;
    }

    public Set<PlantDTO> getPlantCollectionDTO() {
        return plantCollectionDTO;
    }

    public void setPlantCollectionDTO(Set<PlantDTO> plantCollectionDTO) {
        this.plantCollectionDTO = plantCollectionDTO;
    }

    public Set<PictureReferenceDTO> getPictureReferenceCollectionDTO() {
        return pictureReferenceCollectionDTO;
    }

    public void setPictureReferenceCollectionDTO(Set<PictureReferenceDTO> pictureReferenceCollectionDTO) {
        this.pictureReferenceCollectionDTO = pictureReferenceCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public PlantReferenceDTO() {
    }

}
