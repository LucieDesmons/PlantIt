package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_historic")
public class UserHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_historic")
    private Long idUserHistoric;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="id_user", nullable=false)
    private User user;


    /***** GETTER & SETTER *****/

    public Long getIdUserHistoric() {
        return idUserHistoric;
    }

    public void setIdUserHistoric(Long idUserHistoric) {
        this.idUserHistoric = idUserHistoric;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /***** CONSTRUCTOR *****/

    public UserHistoric() {

    }

    public UserHistoric(Date startDate, Date endDate, User user) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "UserHistoric [startDate=" + startDate + ", endDate=" + endDate + ", user=" + user.getIdUser() + "]";
    }

}