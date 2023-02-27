package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.PasswordHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordHistoricRepository extends JpaRepository<PasswordHistoric, Long> {

}
