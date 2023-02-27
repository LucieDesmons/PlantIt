package com.plantit.dal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ManageKey implements Serializable {

    @Column(name = "id_user_customer")
    private int userIdCustomer;

    @Column(name = "id_user_botanist")
    private int userIdBotanist;


    /***** GETTER & SETTER *****/

    public int getUserIdCustomer() {
        return userIdCustomer;
    }

    public void setUserIdCustomer(int userIdCustomer) {
        this.userIdCustomer = userIdCustomer;
    }

    public int getUserIdBotanist() {
        return userIdBotanist;
    }

    public void setUserIdBotanist(int userIdBotanist) {
        this.userIdBotanist = userIdBotanist;
    }

}