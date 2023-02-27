package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_picture")
    private Long idPicture;

    @Column(name = "way")
    private String way;

    @Column(name = "update_date")
    private Date updateDate;


    /***** COLLECTION *****/

    @ManyToMany(mappedBy = "pictureCollection")
    private Set<Maintenance> maintenanceCollection;

    @ManyToMany(mappedBy = "pictureCollection")
    private Set<Plant> plantCollection;


    /***** GETTER & SETTER *****/

    public Long getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(Long idPicture) {
        this.idPicture = idPicture;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<Maintenance> getMaintenanceCollection() {
        return maintenanceCollection;
    }
    public Set<Plant> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<Plant> plantCollection) {
        this.plantCollection = plantCollection;
    }


    public void setMaintenanceCollection(Set<Maintenance> maintenanceCollection) {
        this.maintenanceCollection = maintenanceCollection;
    }


    /***** CONSTRUCTOR *****/

    public Picture() {

    }

    public Picture(String way, Date updateDate) {
        super();
        this.way = way;
        this.updateDate = updateDate;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Picture [way=" + way + ", updateDate=" + updateDate + "]";
    }

}