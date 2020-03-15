package com.itrainmyself.springboot.controller;

import com.itrainmyself.springboot.entity.User;
import com.itrainmyself.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUSers() {
        return userService.getAllUsers();
    }
}
