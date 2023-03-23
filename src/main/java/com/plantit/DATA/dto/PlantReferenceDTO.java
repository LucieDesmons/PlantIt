package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idPlantReference"
)
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
    @JsonIgnore
    private Set<PlantDTO> plantCollection;
    private Set<PictureReferenceDTO> pictureReferenceCollection;

}
