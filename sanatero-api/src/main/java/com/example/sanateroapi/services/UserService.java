package com.example.sanateroapi.services;

import com.example.sanateroapi.models.Role;
import com.example.sanateroapi.models.User;
import com.example.sanateroapi.repositories.RoleRepository;
import com.example.sanateroapi.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    public Integer getPatientsPerDoctorRatio() {
        Role doctorRole = roleRepository.getByName("doctor");
        Role patientRole = roleRepository.getByName("patient");

        Integer countDoctors = this.userRepository.countUserByRole(doctorRole);
        Integer countPatients = this.userRepository.countUserByRole(patientRole);

        try {
            return countPatients / countDoctors;
        } catch (ArithmeticException e) {
            logger.error("Arithmetic exception in getPatientsByDoctorRatio", e);
            return 0;
        }
    }
}
