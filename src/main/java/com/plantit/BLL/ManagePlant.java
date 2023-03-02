package com.plantit.BLL;

import com.plantit.BLL.converter.PlantConverter;
import com.plantit.DATA.dal.entities.Plant;
import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dal.repositories.ConversationRepository;
import com.plantit.DATA.dal.repositories.PlantReferenceRepository;
import com.plantit.DATA.dal.repositories.PlantRepository;
import com.plantit.DATA.dal.repositories.UserRepository;
import com.plantit.DATA.dto.PlantDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManagePlant {
    // picture, conversation , user, plantReference
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;
    private final ConversationRepository conversationRepository;
    private final PlantReferenceRepository plantReferenceRepository;

    private final PlantConverter plantConverter;


    public ManagePlant(PlantRepository plantRepository, UserRepository userRepository, ConversationRepository conversationRepository, PlantReferenceRepository plantReferenceRepository, PlantConverter plantConverter) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
        this.conversationRepository = conversationRepository;
        this.plantReferenceRepository = plantReferenceRepository;
        this.plantConverter = plantConverter;
    }

    public PlantDTO createPlant(PlantDTO plantDTO) {
//        Plant plant = new Plant();
//
//        // TODO: 01/03/2023 setPlantReference dans createPlant
////        if (plantDTO.getPlantReferenceDTO() != null){
////            plant.setPlantReference(new PlantReference(plantDTO.getPlantReferenceDTO()));
////        }
//
//        if (plantDTO.getUserDTO() != null){
//            // TODO: 01/03/2023 en theorie, on devrai avoir l'utilisateur connecté à l'app dans plantDTO
//            Optional<User> currentUser = userRepository.findById(plantDTO.getUserDTO().getIdUserDTO());
//            if (currentUser.isPresent())
//                plant.setUser(currentUser.get());
//        }
//        // TODO: 01/03/2023 conversation
//        // TODO: 01/03/2023 images
////        if (plantDTO.getConversationCollectionDTO() != null)
////            plant.setConversationCollection();
//        plant.setPlacePlant(plantDTO.getPlacePlant());
//        plant.setContainer(plantDTO.getContainer());
//        plant.setClarity(plantDTO.getClarity());
//        plant.setHumidity(plantDTO.getHumidity());

        Plant plant = plantConverter.convertDtoToEntity(plantDTO);

        Optional<User> currentUser = userRepository.findById(plantDTO.getUser().getIdUser());
        if (currentUser.isPresent())
            plant.setUser(currentUser.get());

        plant = plantRepository.save(plant);

        return plantConverter.convertEntityToDTO(plant);
    }

    public List<PlantDTO> getPlants(){

        return plantRepository.findAll().stream()
                .map((plant)-> plantConverter.convertEntityToDTO(plant))
                .collect(Collectors.toList());
    }

    public Optional<PlantDTO> getPlantById(long id){
        Optional<Plant> existingPlant = plantRepository.findById(id);
        if (existingPlant.isPresent()){
            PlantDTO dto = plantConverter.convertEntityToDTO(existingPlant.get());

            return Optional.ofNullable(dto);
        }
        else return Optional.empty();
    }

    public void deletePlant(long id){
        Optional<Plant> existingPlant = plantRepository.findById(id);
        if (existingPlant.isPresent()){
            plantRepository.delete(existingPlant.get());
        }
        else throw new NotFoundException("La plant que vous essayez de supprimer n'éxiste pas.");;
    }

    public List<PlantDTO> getPlantFromIdUser(long idUser){

        return plantRepository.findByUser_IdUser(idUser)
                .stream().map((plant)-> plantConverter.convertEntityToDTO(plant))
                .collect(Collectors.toList());
    }


}
