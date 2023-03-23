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
public class PictureDTO {

    private Long idPicture;
    private String way;
    private Date updateDate;
    private Set<MaintenanceDTO> maintenanceCollection;
    private Set<PlantDTO> plantCollection;

}
