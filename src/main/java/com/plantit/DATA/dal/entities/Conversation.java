package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conversation")
    private Long idConversation;

    @ManyToOne
    @JoinColumn(name="id_user_1", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name="id_user_2", nullable = false)
    private User user2;


    /***** COLLECTION *****/

    @OneToMany(mappedBy="conversation")
    private Set<Message> messageCollection;

    @ManyToMany(mappedBy = "conversationCollection")
    private Set<Plant> plantCollection;


    /***** GETTER & SETTER *****/

    public Long getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(Long idConversation) {
        this.idConversation = idConversation;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Set<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Set<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public Set<Plant> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<Plant> plantCollection) {
        this.plantCollection = plantCollection;
    }


    /***** CONSTRUCTOR *****/

    public Conversation() {

    }

    public Conversation(User user1, User user2) {
        super();
        this.user1 = user1;
        this.user2 = user2;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Conversation [user1=" + user1.getIdUser() + ", user2=" + user2.getIdUser() + "]";
    }

}