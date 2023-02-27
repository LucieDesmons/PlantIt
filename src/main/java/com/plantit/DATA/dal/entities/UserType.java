package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_type")
    private Long idUserType;

    @Column(name = "label")
    private String label;


    /***** COLLECTION *****/

    @OneToMany(mappedBy="userType")
    private Set<User> userCollection;


    /***** GETTER & SETTER *****/

    public Long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Long idUserType) {
        this.idUserType = idUserType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Set<User> userCollection) {
        this.userCollection = userCollection;
    }


    /***** CONSTRUCTOR *****/

    public UserType() {

    }

    public UserType(String label) {
        super();
        this.label = label;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "UserType [label=" + label + "]";
    }

}