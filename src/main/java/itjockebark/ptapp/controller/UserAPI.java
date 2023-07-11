package itjockebark.ptapp.controller;

import itjockebark.ptapp.model.dto.UserGetDTO;
import itjockebark.ptapp.model.dto.UserRegisterDTO;
import itjockebark.ptapp.service.UserService;
import itjockebark.ptapp.utils.ApiDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api")
public class UserAPI {

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiDescription("Register a user")
    ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO dto) {
        try {
            userService.registerUser(dto);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('permission:admin')")
    @ApiDescription("Get all users")
    ResponseEntity<List<UserGetDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

 /*   @GetMapping("{id}")
    @PreAuthorize("hasAuthority('permission:all')")
    @ApiDescription("Get user by id")
    ResponseEntity<UserGetDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
*/
}
