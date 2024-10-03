package com.grigoryanm.library.controllers;

import com.grigoryanm.library.models.User;
import com.grigoryanm.library.repositories.UserRepository;
import com.grigoryanm.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user) == null ? "User with this username already exists" : "Successfully registered user!";
    }
}
