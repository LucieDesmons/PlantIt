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
@Table(name = "picture_reference")
public class PictureReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_picture_reference")
    private Long idPictureReference;

    @Column(name = "way")
    private String way;

    @Column(name = "modification_date")
    private Date modificationDate;

    @ManyToMany
    @JoinTable(
        name = "reference_picture",
        joinColumns = @JoinColumn(name = "id_plant_reference"),
        inverseJoinColumns = @JoinColumn(name = "id_picture_reference")
    )
    private Set<PlantReference> plantReferenceCollection;



    /***** CONSTRUCTOR *****/

    public PictureReference(String way, Date modificationDate) {
        super();
        this.way = way;
        this.modificationDate = modificationDate;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Picture [way=" + way + ", modificationDate=" + modificationDate + "]";
    }

}