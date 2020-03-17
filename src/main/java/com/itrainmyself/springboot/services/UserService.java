package com.itrainmyself.springboot.services;

import com.itrainmyself.springboot.entity.User;
import com.itrainmyself.springboot.exceptions.UserExistException;
import com.itrainmyself.springboot.exceptions.UserNotFoundException;
import com.itrainmyself.springboot.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) throws UserExistException {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            throw new UserExistException("User Alrady Exist");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("User Not Founnd in Repository");
        }
        return user;
    }

    public User updateUserById(Long id, User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
        userRepository.deleteById(id);

    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
