package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long idAddress;

    @Column(name = "number")
    private int number;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "way")
    private String way;

    @Column(name = "additional_address")
    private String additionalAddress;

    @Column(name = "town")
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

    public Address() {

    }

    public Address(int number, int postalCode, String way, String additionalAddress, String town) {
        super();
        this.number = number;
        this.postalCode = postalCode;
        this.way = way;
        this.additionalAddress = additionalAddress;
        this.town = town;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Address [idAddress=" + idAddress + ", number=" + number + ", postalCode=" + postalCode
                + ", way=" + way + ", additionalAddress=" + additionalAddress + ", town=" + town + "]";
    }

}