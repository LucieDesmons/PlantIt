package com.plantit.controllers;

import com.plantit.API.Controller.PlantController;
import com.plantit.API.Controller.UserController;
import com.plantit.BLL.converter.AddressConverter;
import com.plantit.BLL.converter.UserConverter;
import com.plantit.DATA.dal.repositories.AddressRepository;
import com.plantit.DATA.dto.PlantDTO;
import com.plantit.DATA.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserFrontController {

    private final UserController userController;
    private final PlantController plantController;
    private final UserConverter userConverter;
    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;

    public UserFrontController(UserController userController, PlantController plantController, UserConverter userConverter, AddressRepository addressRepository, AddressConverter addressConverter) {
        this.userController = userController;
        this.plantController = plantController;
        this.userConverter = userConverter;
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
        model.addAttribute("user", userDTO);

        userDTO.setAddress(addressConverter.convertEntityToDTO(addressRepository.findById(1L).get()));
        UserDTO createdUser = userConverter.convertEntityToDTO(userController.createCustomer(userDTO).getBody());

        String redirect = String.format("redirect:user/%s/plants", createdUser.getIdUser());

        return redirect;
    }

    @GetMapping("/user/{id}/profile")
    public String showUserProfile(Model model, @PathVariable long id) {
        UserDTO userDTO = userController.getUserById(id).getBody();

        model.addAttribute("user", userDTO);

        return "profil";
    }

    @GetMapping("/user/{id}/plants")
    public String showUserPlants(Model model, @PathVariable long id){
        List<PlantDTO> listPlants = plantController.getUserPLants(id).getBody();

        model.addAttribute("plants", listPlants);

        return "userPlants";
    }

}
