package com.plantit.DATA.dto;

import java.util.Date;

public class MessageDTO {

    private Long idMessage;
    private String label;
    private Date updateDate;
    private ConversationDTO conversation;


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

    public ConversationDTO getConversation() {
        return conversation;
    }

    public void setConversation(ConversationDTO conversation) {
        this.conversation = conversation;
    }


    /***** CONSTRUCTOR *****/

    public MessageDTO() {
    }

}
