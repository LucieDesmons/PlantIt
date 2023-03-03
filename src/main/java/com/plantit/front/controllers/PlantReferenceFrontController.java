package com.plantit.front.controllers;

import com.plantit.DATA.dto.PlantReferenceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plantReference")
public class PlantReferenceFrontController {

    @GetMapping("/Create")
    public String showCreateForm(Model model) {

        PlantReferenceDTO plantReferenceDTO = new PlantReferenceDTO();

        model.addAttribute("plantReference", plantReferenceDTO);

        return "createPlantReferenceForm";
    }

    @PostMapping("/Create")
    public String createPlanteReference(PlantReferenceDTO plantReferenceDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create plante reference";
        }

        return "chepa";
    }

}
