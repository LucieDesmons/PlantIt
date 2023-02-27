package com.plantit.DATA.dto.service.impl;

import com.plantit.DATA.dal.entities.CreatedBy;
import com.plantit.DATA.dal.repositories.CreatedByRepository;
import com.plantit.DATA.dto.service.CreatedByService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatedByServiceImpl implements CreatedByService {

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
