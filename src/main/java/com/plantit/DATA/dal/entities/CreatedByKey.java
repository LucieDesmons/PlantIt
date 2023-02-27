package com.plantit.dal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CreatedByKey implements Serializable {

    @Column(name = "id_plant_reference")
    private int idPlantReference;

    @Column(name = "id_user")
    private int idUser;


    /***** GETTER & SETTER *****/

    public int getIdPlantReference() {
        return idPlantReference;
    }

    public void setIdPlantReference(int idPlantReference) {
        this.idPlantReference = idPlantReference;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
