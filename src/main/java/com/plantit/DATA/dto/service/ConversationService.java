package com.plantit.DATA.dto.service;

import com.plantit.DATA.dal.entities.Conversation;

import java.util.List;

public interface ConversationService {

    Conversation createConversation(Conversation c);

    Conversation saveConversation(Conversation c);

    Conversation updateConversation(Conversation c);

    void deleteConversation(Conversation c);

    void deleteConversationById(Long id);

    Conversation getConversation(Long id);

    List<Conversation> getAllConversations();

}
