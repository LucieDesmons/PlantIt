package com.plantit.DATA.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
