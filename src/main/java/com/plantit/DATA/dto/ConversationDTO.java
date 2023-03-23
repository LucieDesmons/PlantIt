package com.plantit.DATA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConversationDTO {

    private Long idConversation;
    private UserDTO user1;
    private UserDTO user2;
    private Set<MessageDTO> messageCollection;
    private Set<PlantDTO> plantCollection;
}
