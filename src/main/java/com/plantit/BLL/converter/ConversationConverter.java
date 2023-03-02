package com.plantit.BLL.converter;

import com.plantit.DATA.dal.entities.Conversation;
import com.plantit.DATA.dto.ConversationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConversationConverter {

    private final ModelMapper modelMapper = new ModelMapper();

    public ConversationDTO convertEntityToDTO(Conversation conversation) {
        //plantDTO.setUser(UserDTO.fromId(plant.getUser().getIdUser()));

        return modelMapper.map(conversation, ConversationDTO.class);
    }

    public Conversation convertDtoToEntity(ConversationDTO conversationDTO) {

        return modelMapper.map(conversationDTO, Conversation.class);
    }

}