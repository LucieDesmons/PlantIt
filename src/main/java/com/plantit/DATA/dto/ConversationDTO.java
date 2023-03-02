package com.plantit.DATA.dto;

import java.util.Set;

public class ConversationDTO {

    private Long idConversation;
    private UserDTO user1;
    private UserDTO user2;
    private Set<MessageDTO> messageCollection;
    private Set<PlantDTO> plantCollection;


    /***** GETTER & SETTER *****/

    public Long getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(Long idConversation) {
        this.idConversation = idConversation;
    }

    public UserDTO getUser1() {
        return user1;
    }

    public void setUser1(UserDTO user1) {
        this.user1 = user1;
    }

    public UserDTO getUser2() {
        return user2;
    }

    public void setUser2(UserDTO user2) {
        this.user2 = user2;
    }

    public Set<MessageDTO> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Set<MessageDTO> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public Set<PlantDTO> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Set<PlantDTO> plantCollection) {
        this.plantCollection = plantCollection;
    }


    /***** CONSTRUCTOR *****/

    public ConversationDTO() {
    }

}
