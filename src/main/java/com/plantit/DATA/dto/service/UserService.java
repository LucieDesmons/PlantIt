package com.plantit.DATA.dto.service;

import com.plantit.DATA.dal.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User u);

    User saveUser(User u);

    User updateUser(User u);

    void deleteUser(User u);

    void deleteUserById(Long id);

    User getUser(Long id);

    List<User> getAllUsers();

}
