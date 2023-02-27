package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.PictureReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureReferenceRepository extends JpaRepository<PictureReference, Long> {

}
