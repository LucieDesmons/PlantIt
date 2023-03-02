package com.plantit.BLL;

import com.plantit.DATA.dal.entities.Plant;
import com.plantit.DATA.dal.entities.PlantReference;
import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dal.repositories.ConversationRepository;
import com.plantit.DATA.dal.repositories.PlantReferenceRepository;
import com.plantit.DATA.dal.repositories.PlantRepository;
import com.plantit.DATA.dal.repositories.UserRepository;
import com.plantit.DATA.dto.PlantDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ManagePlant {
    // picture, conversation , user, plantReference
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;
    private final ConversationRepository conversationRepository;
    private final PlantReferenceRepository plantReferenceRepository;


    public ManagePlant(PlantRepository plantRepository, UserRepository userRepository, ConversationRepository conversationRepository, PlantReferenceRepository plantReferenceRepository) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
        this.conversationRepository = conversationRepository;
        this.plantReferenceRepository = plantReferenceRepository;
    }

    public Plant createPlant(PlantDTO plantDTO) {
        Plant plant = new Plant();

        // TODO: 01/03/2023 setPlantReference dans createPlant 
//        if (plantDTO.getPlantReferenceDTO() != null){
//            plant.setPlantReference(new PlantReference(plantDTO.getPlantReferenceDTO()));
//        }

        if (plantDTO.getUserDTO() != null){
            // TODO: 01/03/2023 en theorie, on devrai avoir l'utilisateur connecté à l'app dans plantDTO
            Optional<User> currentUser = userRepository.findById(plantDTO.getUserDTO().getIdUserDTO());
            if (currentUser.isPresent())
                plant.setUser(currentUser.get());
        }
        // TODO: 01/03/2023 conversation
        // TODO: 01/03/2023 images
//        if (plantDTO.getConversationCollectionDTO() != null)
//            plant.setConversationCollection();
        plant.setPlacePlant(plantDTO.getPlacePlant());
        plant.setContainer(plantDTO.getContainer());
        plant.setClarity(plantDTO.getClarity());
        plant.setHumidity(plantDTO.getHumidity());

        return plantRepository.save(plant);
    }
}
