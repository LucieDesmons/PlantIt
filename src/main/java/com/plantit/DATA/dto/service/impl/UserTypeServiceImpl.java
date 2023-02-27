package com.plantit.dto.service.impl;

import com.plantit.dal.entities.UserType;
import com.plantit.dal.repositories.UserTypeRepository;
import com.plantit.dto.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    UserTypeRepository userTypeRepository;

    public UserType createUserType(UserType u) {
        return userTypeRepository.save(u);
    }
    @Override
    public UserType saveUserType(UserType u) {
        return userTypeRepository.save(u);
    }

    @Override
    public UserType updateUserType(UserType u) {
        return userTypeRepository.save(u);
    }

    @Override
    public void deleteUserType(UserType u) {
        userTypeRepository.delete(u);
    }

    @Override
    public void deleteUserTypeById(Long id) {
        userTypeRepository.deleteById(id);
    }

    @Override
    public UserType getUserType(Long id) {
        return userTypeRepository.findById(id).get();
    }

    @Override
    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

}
