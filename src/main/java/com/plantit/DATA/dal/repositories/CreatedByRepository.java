package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.CreatedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatedByRepository extends JpaRepository<CreatedBy, Integer> {

}
