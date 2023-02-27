package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.PlantReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlantReferenceRepository extends JpaRepository<PlantReference, Long> {

}
