package com.plantit.dto.service.impl;

import com.plantit.dal.entities.User;
import com.plantit.dal.repositories.UserRepository;
import com.plantit.dto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User u) {
        return userRepository.save(u);
    }
    public User saveUser(User u) { return userRepository.save(u); };
    public User updateUser(User u) { return userRepository.save(u); };
    public void deleteUser(User u) { userRepository.delete(u); };
    public void deleteUserById(Long id) { userRepository.deleteById(id); };
    public User getUser(Long id) { return userRepository.findById(id).get(); };
    public List<User> getAllUsers() { return userRepository.findAll(); };

}
