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


    /***** CONSTRUCTOR *****/

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