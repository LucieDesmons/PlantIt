package com.plantit.dto.service.impl;

import com.plantit.dal.entities.PasswordHistoric;
import com.plantit.dal.repositories.PasswordHistoricRepository;
import com.plantit.dto.service.PasswordHistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordHistoricServiceImpl implements PasswordHistoricService {

    @Autowired
    PasswordHistoricRepository passwordHistoricRepository;

    public PasswordHistoric createPasswordHistoric(PasswordHistoric p) {
        return passwordHistoricRepository.save(p);
    }
    public PasswordHistoric savePasswordHistoric(PasswordHistoric p) { return passwordHistoricRepository.save(p); };
    public PasswordHistoric updatePasswordHistoric(PasswordHistoric p) { return passwordHistoricRepository.save(p); };
    public void deletePasswordHistoric(PasswordHistoric p) { passwordHistoricRepository.delete(p); };
    public void deletePasswordHistoricById(Long id) { passwordHistoricRepository.deleteById(id); };
    public PasswordHistoric getPasswordHistoric(Long id) { return passwordHistoricRepository.findById(id).get(); };
    public List<PasswordHistoric> getAllPasswordHistorics() { return passwordHistoricRepository.findAll(); };

}
