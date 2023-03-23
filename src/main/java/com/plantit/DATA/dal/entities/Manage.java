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
@Table(name = "manage")
public class Manage {

    @EmbeddedId
    private ManageKey idManage;

    @ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "id_user_customer")
    private User idUserCustomer;

    @ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "id_user_botanist")
    private User idUserBotanist;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;


    /***** CONSTRUCTOR *****/

    public Manage(User idUserCustomer, User idUserBotanist, Date startDate, Date endDate) {
        super();
        this.idUserCustomer = idUserCustomer;
        this.idUserBotanist = idUserBotanist;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Manage [userIdCustomer" + idUserCustomer.getIdUser() + "userIdBotanist=" + idUserBotanist.getIdUser() + "startDate" + startDate + "endDate=" + endDate +"]";
    }

}