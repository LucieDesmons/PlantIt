package com.plantit.dto;

import java.util.Set;

public class ConversationDTO {

    private Long idConversationDTO;
    private UserDTO user1DTO;
    private UserDTO user2DTO;
    private Set<MessageDTO> messageCollectionDTO;
    private Set<PlantDTO> plantCollectionDTO;


    /***** GETTER & SETTER *****/

    public Long getIdConversationDTO() {
        return idConversationDTO;
    }

    public void setIdConversationDTO(Long idConversationDTO) {
        this.idConversationDTO = idConversationDTO;
    }

    public UserDTO getUser1DTO() {
        return user1DTO;
    }

    public void setUser1DTO(UserDTO user1DTO) {
        this.user1DTO = user1DTO;
    }

    public UserDTO getUser2DTO() {
        return user2DTO;
    }

    public void setUser2DTO(UserDTO user2DTO) {
        this.user2DTO = user2DTO;
    }

    public Set<MessageDTO> getMessageCollectionDTO() {
        return messageCollectionDTO;
    }

    public void setMessageCollectionDTO(Set<MessageDTO> messageCollectionDTO) {
        this.messageCollectionDTO = messageCollectionDTO;
    }

    public Set<PlantDTO> getPlantCollectionDTO() {
        return plantCollectionDTO;
    }

    public void setPlantCollectionDTO(Set<PlantDTO> plantCollectionDTO) {
        this.plantCollectionDTO = plantCollectionDTO;
    }


    /***** CONSTRUCTOR *****/

    public ConversationDTO() {
    }

}
