package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.swing.text.View;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlantDTO {

    private Long idPlant;
    private String name;
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

    @JsonProperty("idUser")
    public void setUserId(Long userId){
        user = UserDTO.fromId(userId);
    }

    /***** CONSTRUCTOR *****/


}
