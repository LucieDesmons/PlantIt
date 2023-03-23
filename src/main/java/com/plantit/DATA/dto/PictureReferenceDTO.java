package com.plantit.DATA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PictureReferenceDTO {

    private Long idPictureReference;
    private String way;
    private Date modificationDate;
    private Set<PlantReferenceDTO> plantReferenceCollection;
}
