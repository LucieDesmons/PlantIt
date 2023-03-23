package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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


    /***** CONSTRUCTOR *****/

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