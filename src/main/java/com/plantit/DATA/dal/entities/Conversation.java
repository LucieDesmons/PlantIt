package com.plantit.DATA.dal.entities;

import com.plantit.DATA.dto.ConversationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    /***** CONSTRUCTOR *****/

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