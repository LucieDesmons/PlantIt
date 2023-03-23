package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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