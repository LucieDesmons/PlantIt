package com.plantit.WEB_API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plantit.BLL.ManageUser;
import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dal.entities.UserType;
import com.plantit.DATA.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@Api(value = "UserController", tags = {"User Management"})
public class UserController {

    private final ManageUser manageUser;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserController(ManageUser manageUser, ObjectMapper objectMapper) {
        this.manageUser = manageUser;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/createCustomer")
    @ApiOperation(value = "Create a new customer", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<User> createCustomer(@RequestBody UserDTO userDTO) {
        User user = manageUser.createCustomer(userDTO);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/createBotanist")
    @ApiOperation(value = "Create a new customer", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<User> createBotanist(@RequestBody UserDTO userDTO) {
        User user = manageUser.createBotanist(userDTO);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        Optional<UserDTO> userDTO = Optional.ofNullable(manageUser.getUserById(userId));
        return userDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*@GetMapping("/users")
    public List<UserDTO> listAllUsers() {
        return manageUser.getAllUsers();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User user = manageUser.updateUser(userId, userDTO);
        UserDTO updatedUserDTO = objectMapper.convertValue(user, UserDTO.class);
        return ResponseEntity.ok().body(updatedUserDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        manageUser.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/type/{userTypeId}")
    public ResponseEntity<List<UserDTO>> getUsersByType(@PathVariable Long userTypeId) {
        List<UserDTO> users = manageUser.getUsersByType(userTypeId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }*/
}
