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
public class ManageDTO {

    private Long idManage;
    private UserDTO idUserCustomer;
    private UserDTO idUserBotanist;
    private Date startDate;
    private Date endDate;
}
