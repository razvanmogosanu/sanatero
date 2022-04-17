package com.example.sanateroapi.services;

import com.example.sanateroapi.models.User;
import com.example.sanateroapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean loginUser(String username, String password) {
        return userRepository.loginUser(username, password);
    }

    public List<User> getAllDoctors() {
        return userRepository.getAllDoctors();
    }

    public Integer getUserWithBiggestExpenses() {
        return this.userRepository.getUserWithBiggestExpenses();
    }
}
