package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user", nullable=false)
    @JsonBackReference
    private User user;


    /***** CONSTRUCTOR *****/

    public UserHistoric(Date startDate, Date endDate, User user) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        String userId = (user != null) ? user.getIdUser().toString() : "null";
        return "UserHistoric [startDate=" + startDate + ", endDate=" + endDate + ", user=" + userId + "]";
    }

}