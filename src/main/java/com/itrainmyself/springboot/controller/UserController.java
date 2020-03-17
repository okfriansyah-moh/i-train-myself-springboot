package com.itrainmyself.springboot.controller;

import com.itrainmyself.springboot.entity.User;
import com.itrainmyself.springboot.exceptions.UserExistException;
import com.itrainmyself.springboot.exceptions.UserNotFoundException;
import com.itrainmyself.springboot.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUSers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
        try {
            userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (UserExistException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            return userService.updateUserById(id, user);
        } catch(UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/users/byusername/{username}")
    public User getUserByUserName(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
