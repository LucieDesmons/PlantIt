package com.plantit.API.Controller;

import com.plantit.BLL.ManageUser;
import com.plantit.DATA.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

   private ManageUser manageUser;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }
}
