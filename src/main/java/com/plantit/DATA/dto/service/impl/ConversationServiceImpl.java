package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Conversation;
import com.plantit.dal.repositories.ConversationRepository;
import com.plantit.dto.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    ConversationRepository conversationRepository;

    public Conversation createConversation(Conversation c) {
        return conversationRepository.save(c);
    }
    public Conversation saveConversation(Conversation c) { return conversationRepository.save(c); };
    public Conversation updateConversation(Conversation c) { return conversationRepository.save(c); };
    public void deleteConversation(Conversation c) { conversationRepository.delete(c); };
    public void deleteConversationById(Long id) { conversationRepository.deleteById(id); };
    public Conversation getConversation(Long id) { return conversationRepository.findById(id).get(); };
    public List<Conversation> getAllConversations() { return conversationRepository.findAll(); };

}
