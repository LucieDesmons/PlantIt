package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

}
