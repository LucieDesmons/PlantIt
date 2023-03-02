package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.View;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class PlantDTO {

    private Long idPlant;
    private String placePlant;
    private String container;
    private int humidity;
    private String clarity;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("idUser")
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

    public Set<ConversationDTO> getConversationCollectionDTO() {
        return conversationCollection;
    }

    public void setConversationCollectionDTO(Set<ConversationDTO> conversationCollectionDTO) {
        this.conversationCollection = conversationCollectionDTO;
    }


    /***** CONSTRUCTOR *****/



}
