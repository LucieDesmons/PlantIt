package com.plantit.dal.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Long idMessage;

    @Column(name = "label")
    private String label;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name="id_conversation", nullable=false)
    private Conversation conversation;


    /***** GETTER & SETTER *****/

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }


    /***** CONSTRUCTOR *****/

    public Message() {

    }

    public Message(String label, Date updateDate, Conversation conversation) {
        super();
        this.label = label;
        this.updateDate = updateDate;
        this.conversation = conversation;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "Message [label=" + label + ", updateDate=" + updateDate + ", idConversation=" + conversation.getIdConversation() +
                ", users conversation=" + conversation.getUser1() +  conversation.getUser2() + "]";
    }

}