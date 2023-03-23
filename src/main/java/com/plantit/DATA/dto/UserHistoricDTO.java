package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserHistoricDTO {

    private Long idUserHistoric;
    private Date startDate;
    private Date endDate;
    private UserDTO user;

}
