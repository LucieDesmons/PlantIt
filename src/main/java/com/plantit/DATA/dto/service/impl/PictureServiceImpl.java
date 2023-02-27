package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Picture;
import com.plantit.dal.repositories.PictureRepository;
import com.plantit.dto.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    public Picture createPicture(Picture p) {
        return pictureRepository.save(p);
    }
    public Picture savePicture(Picture p) { return pictureRepository.save(p); };
    public Picture updatePicture(Picture p) { return pictureRepository.save(p); };
    public void deletePicture(Picture p) { pictureRepository.delete(p); };
    public void deletePictureById(Long id) { pictureRepository.deleteById(id); };
    public Picture getPicture(Long id) { return pictureRepository.findById(id).get(); };
    public List<Picture> getAllPictures() { return pictureRepository.findAll(); };

}
