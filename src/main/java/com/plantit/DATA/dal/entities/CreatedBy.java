package com.plantit.DATA.dal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "created_by")
public class CreatedBy {

    @EmbeddedId
    private CreatedByKey id;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @MapsId("id_plant_reference")
    @JoinColumn(name = "id_plant_reference")
    private PlantReference plantReference;

    @ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "id_user")
    private User user;


    /***** CONSTRUCTOR *****/

    public CreatedBy(PlantReference PlantReference, User user, int orderNum, Date updateDate) {
        super();
        this.plantReference = PlantReference;
        this.user = user;
        this.orderNum = orderNum;
        this.updateDate = updateDate;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "CreatedBy [idPlantReference" + plantReference.getIdPlantReference() + "userIdUser=" + user.getIdUser()
                + ", orderNum=" + orderNum + "updateDate" + updateDate + "]";
    }

}