package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.Manage;

@Repository
public interface ManageRepository extends JpaRepository<Manage, Integer> {

}
