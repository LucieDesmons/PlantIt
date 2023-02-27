package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.PlantReference;


@Repository
public interface PlantReferenceRepository extends JpaRepository<PlantReference, Long> {

}
