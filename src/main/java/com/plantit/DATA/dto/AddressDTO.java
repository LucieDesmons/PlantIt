package com.plantit.dto;

public class AddressDTO {

    private Long idAddressDTO;
    private int number;
    private int postalCode;
    private String way;
    private String additionalAddress;
    private String town;
    private UserDTO userDTO;


    /***** GETTER & SETTER *****/

    public Long getIdAddressDTO() {
        return idAddressDTO;
    }

    public void setIdAddressDTO(Long idAddressDTO) {
        this.idAddressDTO = idAddressDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


    /***** CONSTRUCTOR *****/

    public AddressDTO() {
    }

}
