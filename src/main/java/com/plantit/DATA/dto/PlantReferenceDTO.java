package com.plantit.DATA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlantReferenceDTO {

    private Long idPlantReference;
    private String name;
    private String family;
    private int size;
    private String foodSource;
    private String reproduction;
    private int lifetime;
    private String placeLife;
    private Set<CreatedByDTO> createdByCollection;
    private Set<PlantDTO> plantCollection;
    private Set<PictureReferenceDTO> pictureReferenceCollection;


    /***** GETTER & SETTER *****/


    /***** CONSTRUCTOR *****/


}
