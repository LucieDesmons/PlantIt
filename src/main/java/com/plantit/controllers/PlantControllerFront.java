package com.plantit.controllers;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.plantit.DATA.dto.PlantDTO;
import com.plantit.DATA.dto.PlantReferenceDTO;

@Controller
public class PlantControllerFront{
    private PlantController back;

    @GetMapping(value = "/show_plant")
    public PlantDTO new_plant(PlantDTO plante) {
        plante.setUserDTO(null); //nécessite de récupérer l'ID utilisateur runtime
        return plante;
    }

    @PostMapping(value = "/get_plant")
    public List<PlantDTO> fiche_plante(@ModelAttribute(value="plante") long id) {
        List<PlantDTO> liste = back.getUserPLants(id);
        return liste;
    }

    @PostMapping(value = "/send_all_plant_reference")
    public List<String> liste_especes() {
        List<PlantReferenceDTO> listeRefs = back.listAllPlants();
        List<String> liste;

        for (PlantReferenceDTO plantee : listeRefs) {
            liste.add(plantee.family);
        }
        return liste;
    }
}