package com.plantit.dto.service;

import com.plantit.dal.entities.UserType;

import java.util.List;

public interface UserTypeService {

    UserType createUserType(UserType u);

    UserType saveUserType(UserType u);

    UserType updateUserType(UserType u);

    void deleteUserType(UserType u);

    void deleteUserTypeById(Long id);

    UserType getUserType(Long id);

    List<UserType> getAllUserTypes();

}
