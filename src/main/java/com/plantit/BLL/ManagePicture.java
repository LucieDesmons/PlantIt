package com.plantit.BLL;

import com.plantit.DATA.dal.entities.Picture;
import com.plantit.DATA.dal.repositories.PictureRepository;
import com.plantit.DATA.dto.PictureDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManagePicture {

    private final PictureRepository repository;

    public ManagePicture(PictureRepository repository) {
        this.repository = repository;
    }

    public Picture createPicture(PictureDTO pictureDTO){
        return repository.save(new Picture(pictureDTO));
    }
}
