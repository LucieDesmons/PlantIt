package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long idAddress;
    private int number;
    private int postalCode;
    private String way;
    private String additionalAddress;
    private String town;
}
