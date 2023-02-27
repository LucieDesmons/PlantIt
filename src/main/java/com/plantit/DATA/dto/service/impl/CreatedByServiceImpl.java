package com.plantit.dto.service.impl;

import com.plantit.dal.entities.CreatedBy;
import com.plantit.dal.repositories.CreatedByRepository;
import com.plantit.dto.service.CreatedByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatedByServiceImpl implements CreatedByService {

    @Autowired
    CreatedByRepository createdByRepository;

    public CreatedBy createCreatedBy(CreatedBy c) {
        return createdByRepository.save(c);
    }
    public CreatedBy saveCreatedBy(CreatedBy c) { return createdByRepository.save(c); };
    public CreatedBy updateCreatedBy(CreatedBy c) { return createdByRepository.save(c); };
    public void deleteCreatedBy(CreatedBy c) { createdByRepository.delete(c); };
    public void deleteCreatedByById(Long id) { createdByRepository.deleteById(Math.toIntExact(id)); };
    public CreatedBy getCreatedBy(Long id) { return createdByRepository.findById(Math.toIntExact(id)).get(); };
    public List<CreatedBy> getAllCreatedBys() { return createdByRepository.findAll(); };

}
