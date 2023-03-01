package com.plantit.BLL;

import com.plantit.DATA.dal.entities.Conversation;
import com.plantit.DATA.dal.repositories.ConversationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManageConversation {
    private final ConversationRepository repository;

    public ManageConversation(ConversationRepository repository) {
        this.repository = repository;
    }

}
