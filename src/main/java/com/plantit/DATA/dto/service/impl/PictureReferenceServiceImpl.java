package com.plantit.dto.service.impl;

import com.plantit.dal.entities.PictureReference;
import com.plantit.dal.repositories.PictureReferenceRepository;
import com.plantit.dto.service.PictureReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureReferenceServiceImpl implements PictureReferenceService {

    @Autowired
    PictureReferenceRepository pictureReferenceRepository;

    public PictureReference createPictureReference(PictureReference p) {
        return pictureReferenceRepository.save(p);
    }
    public PictureReference savePictureReference(PictureReference p) { return pictureReferenceRepository.save(p); };
    public PictureReference updatePictureReference(PictureReference p) { return pictureReferenceRepository.save(p); };
    public void deletePictureReference(PictureReference p) { pictureReferenceRepository.delete(p); };
    public void deletePictureReferenceById(Long id) { pictureReferenceRepository.deleteById(id); };
    public PictureReference getPictureReference(Long id) { return pictureReferenceRepository.findById(id).get(); };
    public List<PictureReference> getAllPictureReferences() { return pictureReferenceRepository.findAll(); };

}
