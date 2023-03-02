package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dal.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserType(UserType type);

    Optional<User> findByLogin(String login);

}
