package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {

    private Long idAddress;
    private int number;
    private int postalCode;
    private String way;
    private String additionalAddress;
    private String town;


    /***** GETTER & SETTER *****/

    @JsonProperty("id_address")
    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }


    /***** CONSTRUCTOR *****/

    public AddressDTO() {
    }

}
