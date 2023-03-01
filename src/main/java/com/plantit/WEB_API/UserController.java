package com.plantit.WEB_API;

import com.plantit.BLL.ManageUser;
import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@Api(value = "UserController", tags = { "User Management" })
public class UserController {

    private final ManageUser manageUser;

    @Autowired
    public UserController(ManageUser manageUser) {
        this.manageUser = manageUser;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new customer", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = manageUser.createCustomer(userDTO);
        return ResponseEntity.ok().body(user);
    }
}
