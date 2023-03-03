package com.plantit.controllers;

import com.plantit.API.Controller.PlantReferenceController;
import com.plantit.DATA.dto.PlantReferenceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/plantReference")
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

        PlantReferenceDTO createdPlantReference = plantReferenceController.createPlant(plantReferenceDTO).getBody();

        String redirect = String.format("redirect:showPlantReference/%s", createdPlantReference.getIdPlantReference());

        return redirect;
    }

    @GetMapping("/showPlantReference/{id}")
    public String showPlantReference(Model model, @PathVariable long id) {

        PlantReferenceDTO plantReferenceDTO = plantReferenceController.getById(id).getBody();

        model.addAttribute("plantReferenceDTO", plantReferenceDTO);

        return "showPlantReference";
    }


    @GetMapping("/showAllPlantReference")
    public String showPlantReference(Model model) {

        List<PlantReferenceDTO> plantReferenceDTOs = plantReferenceController.listAllPlants().getBody();

        model.addAttribute("listPlantReference", plantReferenceDTOs);

        return "showAllPlantReference";
    }




}
