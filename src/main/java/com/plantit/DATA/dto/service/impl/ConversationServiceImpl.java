package com.plantit.DATA.dto.service.impl;

import com.plantit.DATA.dal.entities.Conversation;
import com.plantit.DATA.dal.repositories.ConversationRepository;
import com.plantit.DATA.dto.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConversationServiceImpl implements ConversationService {

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
