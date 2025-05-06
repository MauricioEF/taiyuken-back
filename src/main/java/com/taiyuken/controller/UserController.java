package com.taiyuken.controller;

import com.taiyuken.model.User;
import com.taiyuken.response.PayloadResponse;
import com.taiyuken.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllVideoGames(){
        //Devolver usuarios
        List<User> users = this.userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",users));
    }

}
