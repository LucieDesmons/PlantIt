package com.plantit.dto.service;

import com.plantit.dal.entities.UserHistoric;

import java.util.List;

public interface UserHistoricService {

    UserHistoric createUserHistoric(UserHistoric u);

    UserHistoric saveUserHistoric(UserHistoric u);

    UserHistoric updateUserHistoric(UserHistoric u);

    void deleteUserHistoric(UserHistoric u);

    void deleteUserHistoricById(Long id);

    UserHistoric getUserHistoric(Long id);

    List<UserHistoric> getAllUserHistorics();

}
