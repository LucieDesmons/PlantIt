package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

}
