package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Message;
import com.plantit.dal.repositories.MessageRepository;
import com.plantit.dto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message createMessage(Message m) {
        return messageRepository.save(m);
    }
    public Message saveMessage(Message m) { return messageRepository.save(m); };
    public Message updateMessage(Message m) { return messageRepository.save(m); };
    public void deleteMessage(Message m) { messageRepository.delete(m); };
    public void deleteMessageById(Long id) { messageRepository.deleteById(id); };
    public Message getMessage(Long id) { return messageRepository.findById(id).get(); };
    public List<Message> getAllMessages() { return messageRepository.findAll(); };

}
