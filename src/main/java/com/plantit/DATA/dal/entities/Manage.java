package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
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


    /***** GETTER & SETTER *****/

    public ManageKey getIdManage() {
        return idManage;
    }

    public void setIdManage(ManageKey idManage) {
        this.idManage = idManage;
    }

    public User getIdUserCustomer() {
        return idUserCustomer;
    }

    public void setIdUserCustomer(User idUserCustomer) {
        this.idUserCustomer = idUserCustomer;
    }

    public User getIdUserBotanist() {
        return idUserBotanist;
    }

    public void setIdUserBotanist(User idUserBotanist) {
        this.idUserBotanist = idUserBotanist;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    /***** CONSTRUCTOR *****/

    public Manage() {

    }

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