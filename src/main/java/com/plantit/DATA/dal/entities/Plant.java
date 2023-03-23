package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "plant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plant")
    private Long idPlant;

    @Column(name = "name")
    private String name;

    @Column(name = "place_plant")
    private String placePlant;

    @Column(name = "container")
    private String container;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "clarity")
    private String clarity;

    @ManyToOne(fetch = FetchType.LAZY)
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

    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Plant [placePlant=" + placePlant + ", container=" + container + ", humidity=" + humidity;// +
                //"clarity=" + clarity + ", idUser=" + this.getUser().getIdUser() + ", idPlantReference=" + plantReference.getIdPlantReference() +"]";
    }

}