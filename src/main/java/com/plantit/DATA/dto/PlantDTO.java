package com.plantit.DATA.dto;

import java.util.Set;

public class PlantDTO {

    private Long idPlant;
    private String placePlant;
    private String container;
    private int humidity;
    private String clarity;
    private UserDTO user;
    private PlantReferenceDTO plantReference;
    private Set<PictureDTO> pictureCollection;
    private Set<ConversationDTO> conversationCollection;


    /***** GETTER & SETTER *****/

    public Long getIdPlant() {
        return idPlant;
    }

    public void setIdPlant(Long idPlant) {
        this.idPlant = idPlant;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PlantReferenceDTO getPlantReference() {
        return plantReference;
    }

    public void setPlantReference(PlantReferenceDTO plantReference) {
        this.plantReference = plantReference;
    }

    public Set<PictureDTO> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Set<PictureDTO> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    public Set<ConversationDTO> getConversationCollection() {
        return conversationCollection;
    }

    public void setConversationCollection(Set<ConversationDTO> conversationCollection) {
        this.conversationCollection = conversationCollection;
    }


    /***** CONSTRUCTOR *****/

    public PlantDTO() {
    }

}
