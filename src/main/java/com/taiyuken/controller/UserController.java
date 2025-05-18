package com.taiyuken.controller;

import com.taiyuken.dto.user.CreateUserRequest;
import com.taiyuken.model.User;
import com.taiyuken.response.MessageResponse;
import com.taiyuken.response.PayloadResponse;
import com.taiyuken.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        //Devolver usuarios
        List<User> users = this.userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success", users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") int id) {
        User user = this.userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("succes", user));
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest request) {
        if (request.getEmail() == null || request.getName() == null || request.getUsername() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("error", "incomplete values"));
        }
        char isEmail = '@';
        for (int i = 0; i < request.getEmail().length(); i++) {
            if (request.getEmail().charAt(i) == isEmail) {
                User user = this.userService.createUser(request);
                return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("succes", user));
            }
        }
        User user = this.userService.createUser(request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("error", "incomplete values"));
    }

}
