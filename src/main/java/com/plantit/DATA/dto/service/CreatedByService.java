package com.plantit.dto.service;

import com.plantit.dal.entities.CreatedBy;

import java.util.List;

public interface CreatedByService {

    CreatedBy createCreatedBy(CreatedBy c);

    CreatedBy saveCreatedBy(CreatedBy c);

    CreatedBy updateCreatedBy(CreatedBy c);

    void deleteCreatedBy(CreatedBy c);

    void deleteCreatedByById(Long id);

    CreatedBy getCreatedBy(Long id);

    List<CreatedBy> getAllCreatedBys();

}
