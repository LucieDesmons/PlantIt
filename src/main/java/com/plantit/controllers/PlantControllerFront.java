package com.plantit.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.plantit.API.Controller.PlantController;
import com.plantit.API.Controller.PlantReferenceController;
import com.plantit.DATA.dto.PlantDTO;
import com.plantit.DATA.dto.PlantReferenceDTO;
import com.plantit.DATA.dto.UserDTO;

@Controller
public class PlantControllerFront{
    private PlantController back;
    private PlantReferenceController backRef;

    @GetMapping(value = "/show_plant")
    public PlantDTO new_plant(PlantDTO plante) {
        UserDTO user = new UserDTO();   //récupère l'ID de l'utilisateur connecté
        plante.setUserDTO(user);
        return plante;
    }

    @PostMapping(value = "/get_plant")
    public List<PlantDTO> fiche_plante(@ModelAttribute(value="plante") long id) {
        List<PlantDTO> liste = back.getUserPLants(id).getBody();
        return liste;
    }

    @PostMapping(value = "/send_all_plant_reference")
    public List<String> liste_especes() {
        List<PlantReferenceDTO> listeRefs = backRef.listAllPlants().getBody();
        List<String> liste = new ArrayList();

        for (PlantReferenceDTO plantee : listeRefs) {
            liste.add(plantee.getFamily());
        }
        return liste;
    }

    @GetMapping(value = "/delete_plant")
    public Long delete_plant(PlantDTO plante){
        return plante.getIdPlantDTO();
    }
}