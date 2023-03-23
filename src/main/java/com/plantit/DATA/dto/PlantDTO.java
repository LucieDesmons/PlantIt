package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idPlant"
)
public class PlantDTO {

    private Long idPlant;
    private String name;
    private String placePlant;
    private String container;
    private int humidity;
    private String clarity;
    private UserDTO user;

    private PlantReferenceDTO plantReference;
    private Set<PictureDTO> pictureCollection;
    private Set<ConversationDTO> conversationCollection;
}
