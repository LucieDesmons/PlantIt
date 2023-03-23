package com.plantit.DATA.dal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maintenance")
    private Long idMaintenance;

    @Column(name = "predicted_date")
    private Date predictedDate;

    @Column(name = "realized_date")
    private Date realizedDate;

    @Column(name = "report")
    private String report;


    /***** JOIN TABLE *****/

    @ManyToMany
    @JoinTable(
            name = "maintenance_picture",
            joinColumns = @JoinColumn(name = "id_maintenance"),
            inverseJoinColumns = @JoinColumn(name = "id_picture"))
    private Set<Picture> pictureCollection;

    @ManyToMany
    @JoinTable(
            name = "maintenance_user",
            joinColumns = @JoinColumn(name = "id_maintenance"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private Set<User> userCollection;


    /***** CONSTRUCTOR *****/

    public Maintenance(Date predictedDate, Date realizedDate, String report) {
        super();
        this.predictedDate = predictedDate;
        this.realizedDate = realizedDate;
        this.report = report;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Maintenance [predictedDate=" + predictedDate + ", realizedDate=" + realizedDate + ", report=" + report + "]";
    }

}