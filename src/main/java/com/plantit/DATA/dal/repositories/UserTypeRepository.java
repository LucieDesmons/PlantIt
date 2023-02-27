package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
