package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.CreatedBy;

@Repository
public interface CreatedByRepository extends JpaRepository<CreatedBy, Integer> {

}
