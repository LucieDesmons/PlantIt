package com.plantit.DATA.dal.repositories;

import com.plantit.DATA.dal.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

}
