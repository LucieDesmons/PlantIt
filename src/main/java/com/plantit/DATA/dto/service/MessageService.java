package com.plantit.dto.service;

import com.plantit.dal.entities.Message;

import java.util.List;

public interface MessageService {

    Message createMessage(Message m);

    Message saveMessage(Message m);

    Message updateMessage(Message m);

    void deleteMessage(Message m);

    void deleteMessageById(Long id);

    Message getMessage(Long id);

    List<Message> getAllMessages();

}
