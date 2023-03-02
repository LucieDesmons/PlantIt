package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByUser_IdUser(@NonNull Long idUser);

}
