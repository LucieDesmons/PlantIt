package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.PictureReference;

@Repository
public interface PictureReferenceRepository extends JpaRepository<PictureReference, Long> {

}
