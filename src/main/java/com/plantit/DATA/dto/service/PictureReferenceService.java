package com.plantit.DATA.dto.service;

import com.plantit.DATA.dal.entities.PictureReference;

import java.util.List;

public interface PictureReferenceService {

    PictureReference createPictureReference(PictureReference p);

    PictureReference savePictureReference(PictureReference p);

    PictureReference updatePictureReference(PictureReference p);

    void deletePictureReference(PictureReference p);

    void deletePictureReferenceById(Long id);

    PictureReference getPictureReference(Long id);

    List<PictureReference> getAllPictureReferences();

}
