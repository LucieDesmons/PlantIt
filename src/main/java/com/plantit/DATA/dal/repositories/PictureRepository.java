package com.plantit.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plantit.dal.entities.Picture;


@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

}
