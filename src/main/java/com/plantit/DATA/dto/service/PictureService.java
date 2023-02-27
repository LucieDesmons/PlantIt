package com.plantit.dto.service;

import com.plantit.dal.entities.Picture;

import java.util.List;

public interface PictureService {

    Picture createPicture(Picture p);

    Picture savePicture(Picture p);

    Picture updatePicture(Picture p);

    void deletePicture(Picture p);

    void deletePictureById(Long id);

    Picture getPicture(Long id);

    List<Picture> getAllPictures();

}
