package com.example.sanateroapi.controllers;

import com.example.sanateroapi.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("login")
    public ResponseEntity<Boolean> loginUser(@RequestHeader String username, @RequestHeader String password ) {
        logger.info("loginUser {baseURL + /user/login}");
        return new ResponseEntity<>(userService.loginUser(username, password), HttpStatus.OK);
    }

    @GetMapping("get_all_doctors")
    public ResponseEntity<?> getAllDoctors() {
        logger.info("getAllDoctors {baseURL + /user/get_all_doctors}");
        return new ResponseEntity<>(userService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("user_with_biggest_expenses")
    public ResponseEntity<?> getUserWithBiggestExpenses() {
        logger.info("getUserWithBiggestExpenses {baseURL + /user/user_with_biggest_expenses}");
        return new ResponseEntity<>(userService.getUserWithBiggestExpenses(), HttpStatus.OK);
    }

}
