package com.plantit.DATA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedByDTO {

    private Long idCreatedBy;
    private int orderNum;
    private Date updateDate;
    private PlantReferenceDTO plantReference;
    private UserDTO user;
}
