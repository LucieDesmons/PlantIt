package com.plantit.API.Controller;

import com.plantit.DATA.dal.entities.UserType;
import com.plantit.DATA.dto.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/api/userType"})
public class UserTypeController {

    private final UserTypeService userTypeService;


    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserType>> getAllUserType(){
        List<UserType> userTypes = userTypeService.getAllUserTypes();
        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }
}
