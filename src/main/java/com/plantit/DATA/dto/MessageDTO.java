package com.plantit.dto;

import java.util.Date;

public class MessageDTO {

    private Long idMessageDTO;
    private String label;
    private Date updateDate;
    private ConversationDTO conversationDTO;


    /***** GETTER & SETTER *****/

    public Long getIdMessageDTO() {
        return idMessageDTO;
    }

    public void setIdMessageDTO(Long idMessageDTO) {
        this.idMessageDTO = idMessageDTO;
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

    public ConversationDTO getConversationDTO() {
        return conversationDTO;
    }

    public void setConversationDTO(ConversationDTO conversationDTO) {
        this.conversationDTO = conversationDTO;
    }


    /***** CONSTRUCTOR *****/

    public MessageDTO() {
    }

}
