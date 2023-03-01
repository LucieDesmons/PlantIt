package com.plantit.BLL;

import com.plantit.DATA.dal.entities.Message;
import com.plantit.DATA.dal.repositories.MessageRepository;
import com.plantit.DATA.dto.MessageDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManageMessage {

    private final MessageRepository messageRepository;

    public ManageMessage(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(MessageDTO messageDTO){
        Message message = new Message();

        message.setLabel(messageDTO.getLabel());
        message.setUpdateDate(messageDTO.getUpdateDate());

        return messageRepository.save(message);
    }
}
