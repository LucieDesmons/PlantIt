package com.plantit.DATA.dal.entities;

import com.plantit.DATA.dto.PictureDTO;
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


    /***** CONSTRUCTOR *****/

    public Picture(String way, Date updateDate) {
        super();
        this.way = way;
        this.updateDate = updateDate;
    }

    public Picture(PictureDTO pictureDTO){
        super();
        this.way = pictureDTO.getWay();
        this.updateDate = pictureDTO.getUpdateDate();
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Picture [way=" + way + ", updateDate=" + updateDate + "]";
    }

}