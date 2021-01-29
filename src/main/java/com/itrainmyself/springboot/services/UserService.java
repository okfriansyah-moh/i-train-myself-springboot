package com.itrainmyself.springboot.services;

import com.itrainmyself.springboot.entity.User;
import com.itrainmyself.springboot.exceptions.UserExistException;
import com.itrainmyself.springboot.exceptions.UserNotFoundException;
import com.itrainmyself.springboot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        /**
         * Logic to get all users
         */
        return userRepository.findAll();
    }

    public User createUser(User user) throws UserExistException {
        /**
         * Logic to create user
         */
        return null;
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        /**
         * Logic to get user by id
         */
        return null;
    }

    public User updateUserById(Long id, User user) throws UserNotFoundException {
        /**
         * Logic to update user by id
         */
        return null;
    }

    public void deleteUserById(Long id) {
        /**
         * Logic to delete user by id
         */
    }

    public User getUserByUsername(String username) {
        /**
         * Logic to get user by user name
         */
        return null;
    }

}
