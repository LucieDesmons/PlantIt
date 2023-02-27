package com.plantit.dto.service.impl;

import com.plantit.dal.entities.UserHistoric;
import com.plantit.dal.repositories.UserHistoricRepository;
import com.plantit.dto.service.UserHistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHistoricServiceImpl implements UserHistoricService {

    @Autowired
    UserHistoricRepository userHistoricRepository;

    public UserHistoric createUserHistoric(UserHistoric u) {
        return userHistoricRepository.save(u);
    }
    public UserHistoric saveUserHistoric(UserHistoric u) { return userHistoricRepository.save(u); };
    public UserHistoric updateUserHistoric(UserHistoric u) { return userHistoricRepository.save(u); };
    public void deleteUserHistoric(UserHistoric u) { userHistoricRepository.delete(u); };
    public void deleteUserHistoricById(Long id) { userHistoricRepository.deleteById(id); };
    public UserHistoric getUserHistoric(Long id) { return userHistoricRepository.findById(id).get(); };
    public List<UserHistoric> getAllUserHistorics() { return userHistoricRepository.findAll(); };

}
