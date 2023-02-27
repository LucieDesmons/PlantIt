package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.PasswordHistoric;

@Repository
public interface PasswordHistoricRepository extends JpaRepository<PasswordHistoric, Long> {

}
