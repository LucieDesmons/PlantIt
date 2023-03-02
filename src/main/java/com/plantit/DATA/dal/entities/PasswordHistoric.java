package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "password_historic")
public class PasswordHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historic")
    private Long idHistoric;

    @Column(name = "password")
    private String password;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnoreProperties("passwordHistoricCollection")
    private User user;


    /***** GETTER & SETTER *****/

    @JsonProperty("idHistoric")
    public Long getIdHistoric() {
        return idHistoric;
    }

    public void setIdHistoric(Long idHistoric) {
        this.idHistoric = idHistoric;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /***** CONSTRUCTOR *****/

    public PasswordHistoric() {

    }

    public PasswordHistoric(String password, Date updateDate, User user) {
        super();
        this.password = password;
        this.updateDate = updateDate;
        this.user = user;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        String userId = (user != null) ? user.getIdUser().toString() : "null";
        return "PasswordHistoric [password=" + password + ", updateDate=" + updateDate + ", idUser=" + userId + "]";
    }

}