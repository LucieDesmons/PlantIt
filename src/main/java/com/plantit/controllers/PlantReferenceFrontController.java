package com.plantit.controllers;

import com.plantit.API.Controller.PlantReferenceController;
import com.plantit.DATA.dto.PlantReferenceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlantReferenceFrontController {

    private final PlantReferenceController plantReferenceController;

    public PlantReferenceFrontController(PlantReferenceController plantReferenceController) {
        this.plantReferenceController = plantReferenceController;
    }

    @GetMapping("/CreateForm")
    public String createForm(Model model) {
        model.addAttribute("plantReferenceDTO", new PlantReferenceDTO());
        return "createPlantReferenceForm";
    }

    @PostMapping("/CreateForm")
    public String CreateFormSubmit(@ModelAttribute("plantReferenceDTO") PlantReferenceDTO plantReferenceDTO, BindingResult result, Model model) {

        model.addAttribute("plantReferenceDTO", plantReferenceDTO);

        plantReferenceController.createPlant(plantReferenceDTO);

        return "showPlantReference";
    }

//    @GetMapping("/showPlantReference/{id}")
//    public String showPlantReference(Model model, RequestParam)




}
