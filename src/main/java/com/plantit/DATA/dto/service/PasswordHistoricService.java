package com.plantit.DATA.dto.service;

import com.plantit.DATA.dal.entities.PasswordHistoric;

import java.util.List;

public interface PasswordHistoricService {

    PasswordHistoric createPasswordHistoric(PasswordHistoric p);

    PasswordHistoric savePasswordHistoric(PasswordHistoric p);

    PasswordHistoric updatePasswordHistoric(PasswordHistoric p);

    void deletePasswordHistoric(PasswordHistoric p);

    void deletePasswordHistoricById(Long id);

    PasswordHistoric getPasswordHistoric(Long id);

    List<PasswordHistoric> getAllPasswordHistorics();

}
