package com.plantit.dto.service;

import com.plantit.dal.entities.Conversation;

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
