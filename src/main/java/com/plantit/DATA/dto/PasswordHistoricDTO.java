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
public class PasswordHistoricDTO {

    private Long idHistoric;
    private String password;
    private Date updateDate;
    private UserDTO user;
}
