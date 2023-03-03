package com.plantit.API.Controller;

import com.plantit.BLL.ManageUser;
import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dal.repositories.UserRepository;
import com.plantit.DATA.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@Api(value = "UserController", tags = { "User Management" })
public class UserController {

    private final ManageUser manageUser;
    private final UserRepository userRepository;

    @Autowired
    public UserController(ManageUser manageUser,
                          UserRepository userRepository) {
        this.manageUser = manageUser;
        this.userRepository = userRepository;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new customer", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public void createCustomer(@RequestBody UserDTO userDTO) {
        manageUser.createCustomer(userDTO);
    }

    // handler method to handle list of users
    @GetMapping("")
//    public String users(Model model){
//        List<UserDTO> users = manageUser.findAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }



    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userRepository.findByEmailIgnoreCase(userDto.getEmail());

        // On vérifie qu'il n'y a pas déjà l'email présent dans la base
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Il y a déjà un compte possédant la même adresse mail");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        manageUser.createUser(userDto);
        return "redirect:/register?success";
    }
}
