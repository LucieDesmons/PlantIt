package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

}
