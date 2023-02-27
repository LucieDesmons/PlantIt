package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "plant_reference")
public class PlantReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plant_reference")
    private Long idPlantReference;

    @Column(name = "family")
    private String family;

    @Column(name = "size")
    private int size;

    @Column(name = "food_source")
    private String foodSource;

    @Column(name = "reproduction")
    private String reproduction;

    @Column(name = "lifetime")
    private int lifetime;

    @Column(name = "place_life")
    private String placeLife;


    /***** COLLECTION *****/

    @OneToMany(mappedBy = "plantReference")
    private Set<CreatedBy> createdByCollection;

    @OneToMany(mappedBy="plantReference")
    private Set<Plant> plantCollection;

    @ManyToMany(mappedBy = "plantReferenceCollection")
    private Set<PictureReference> pictureReferenceCollection;


    /***** GETTER & SETTER *****/

    public Long getIdPlantReference() {
        return idPlantReference;
    }

    public void setIdPlantReference(Long idPlantReference) {
        this.idPlantReference = idPlantReference;
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

    public Set<CreatedBy> getCreatedByCollection() {
        return createdByCollection;
    }

    public void setCreatedByCollection(Set<CreatedBy> createdByCollection) {
        this.createdByCollection = createdByCollection;
    }

    public Set<Plant> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<Plant> plantCollection) {
        this.plantCollection = plantCollection;
    }

    public Set<PictureReference> getPictureReferenceCollection() {
        return pictureReferenceCollection;
    }

    public void setPictureReferenceCollection(Set<PictureReference> pictureReferenceCollection) {
        this.pictureReferenceCollection = pictureReferenceCollection;
    }


    /***** CONSTRUCTOR *****/

    public PlantReference() {

    }

    public PlantReference(String family, int size, String foodSource, String reproduction, int lifetime, String placeLife) {
        super();
        this.family = family;
        this.size = size;
        this.foodSource = foodSource;
        this.reproduction = reproduction;
        this.lifetime = lifetime;
        this.placeLife = placeLife;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "PlantReference [family=" + family + ", size=" + size + "foodSource=" + foodSource + ", reproduction=" + reproduction +
                "lifetime=" + lifetime + ", placeLife=" + placeLife + "]";
    }

}