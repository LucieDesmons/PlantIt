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
public class MaintenanceDTO {

    private Long idMaintenance;
    private Date predictedDate;
    private Date realizedDate;
    private String report;
    private Set<PictureDTO> pictureCollection;
    private Set<UserDTO> userCollection;
}
