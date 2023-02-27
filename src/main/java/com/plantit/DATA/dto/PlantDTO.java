package com.plantit.dto;

import java.util.Set;

public class PlantDTO {

    private Long idPlantDTO;
    private String placePlant;
    private String container;
    private int humidity;
    private String clarity;
    private UserDTO userDTO;
    private PlantReferenceDTO plantReferenceDTO;
    private Set<PictureDTO> pictureCollectionDTO;
    private Set<ConversationDTO> conversationCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdPlantDTO() {
        return idPlantDTO;
    }

    public void setIdPlantDTO(Long idPlantDTO) {
        this.idPlantDTO = idPlantDTO;
    }

    public String getPlacePlant() {
        return placePlant;
    }

    public void setPlacePlant(String placePlant) {
        this.placePlant = placePlant;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getClarity() {
        return clarity;
    }

    public void setClarity(String clarity) {
        this.clarity = clarity;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public PlantReferenceDTO getPlantReferenceDTO() {
        return plantReferenceDTO;
    }

    public void setPlantReferenceDTO(PlantReferenceDTO plantReferenceDTO) {
        this.plantReferenceDTO = plantReferenceDTO;
    }

    public Set<PictureDTO> getPictureCollectionDTO() {
        return pictureCollectionDTO;
    }

    public void setPictureCollectionDTO(Set<PictureDTO> pictureCollectionDTO) {
        this.pictureCollectionDTO = pictureCollectionDTO;
    }

    public Set<ConversationDTO> getConversationCollectionDTO() {
        return conversationCollectionDTO;
    }

    public void setConversationCollectionDTO(Set<ConversationDTO> conversationCollectionDTO) {
        this.conversationCollectionDTO = conversationCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public PlantDTO() {
    }

}
