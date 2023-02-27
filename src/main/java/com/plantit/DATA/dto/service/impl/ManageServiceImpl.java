package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Manage;
import com.plantit.dal.repositories.ManageRepository;
import com.plantit.dto.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageRepository manageRepository;

    public Manage createManage(Manage m) {
        return manageRepository.save(m);
    }
    public Manage saveManage(Manage m) { return manageRepository.save(m); };
    public Manage updateManage(Manage m) { return manageRepository.save(m); };
    public void deleteManage(Manage m) { manageRepository.delete(m); };
    public void deleteManageById(Long id) { manageRepository.deleteById(Math.toIntExact(id)); };
    public Manage getManage(Long id) { return manageRepository.findById(Math.toIntExact(id)).get(); };
    public List<Manage> getAllManages() { return manageRepository.findAll(); };

}
