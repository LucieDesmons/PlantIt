package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.UserHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoricRepository extends JpaRepository<UserHistoric, Long> {

}
