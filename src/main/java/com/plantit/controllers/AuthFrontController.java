package com.plantit.controllers;

import com.plantit.DATA.dto.UserDTO;
import com.plantit.auth.AuthenticationController;
import com.plantit.auth.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AuthFrontController {
    private final AuthenticationController authController;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new UserDTO());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserDTO user, BindingResult result) {
        AuthenticationRequest authRequest = AuthenticationRequest.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        authController.authenticate(authRequest);

        // TODO se renseigner sur l'auth coté front
        return "home";
    }


}
