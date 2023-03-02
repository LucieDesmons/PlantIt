package com.plantit.DATA.dal.entities;

import com.plantit.DATA.dto.PlantReferenceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plant_reference")
public class PlantReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plant_reference")
    private Long idPlantReference;

    @Column(name = "family")
    private String family;

    @Column(name = "name")
    private String name;

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


    /***** CONSTRUCTOR *****/

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