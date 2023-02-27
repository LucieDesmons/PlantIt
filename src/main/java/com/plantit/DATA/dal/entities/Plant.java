package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plant")
    private Long idPlant;

    @Column(name = "place_plant")
    private String placePlant;

    @Column(name = "container")
    private String container;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "clarity")
    private String clarity;

    @ManyToOne
    @JoinColumn(name="id_user", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="id_plant_reference")
    private PlantReference plantReference;

    @ManyToMany
    @JoinTable(
            name = "plant_picture",
            joinColumns = @JoinColumn(name = "id_plant"),
            inverseJoinColumns = @JoinColumn(name = "id_picture")
    )
    private Set<Picture> pictureCollection;

    @ManyToMany
    @JoinTable(
            name = "plant_conversation",
            joinColumns = @JoinColumn(name = "id_plant"),
            inverseJoinColumns = @JoinColumn(name = "id_conversation")
    )
    private Set<Conversation> conversationCollection;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PlantReference getPlantReference() {
        return plantReference;
    }

    public void setPlantReference(PlantReference plantReference) {
        this.plantReference = plantReference;
    }

    public Set<Picture> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Set<Picture> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    public Set<Conversation> getConversationCollection() {
        return conversationCollection;
    }

    public void setConversationCollection(Set<Conversation> conversationCollection) {
        this.conversationCollection = conversationCollection;
    }


    /***** CONSTRUCTOR *****/

    public Plant() {

    }

    public Plant(String placePlant, String container, int humidity, String clarity, User user, PlantReference plantReference) {
        super();
        this.placePlant = placePlant;
        this.container = container;
        this.humidity = humidity;
        this.clarity = clarity;
        this.user = user;
        this.plantReference = plantReference;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Plant [placePlant=" + placePlant + ", container=" + container + ", humidity=" + humidity +
                "clarity=" + clarity + ", idUser=" + user.getIdUser() + ", idPlantReference=" + plantReference.getIdPlantReference() +"]";
    }

}