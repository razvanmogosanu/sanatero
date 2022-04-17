package com.example.sanateroapi.controllers;

import com.example.sanateroapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("login")
    public ResponseEntity<Boolean> loginUser(@RequestHeader String username, @RequestHeader String password ) {
        return new ResponseEntity<>(userService.loginUser(username, password), HttpStatus.ACCEPTED);
    }

    @GetMapping("get_all_doctors")
    public ResponseEntity<?> getAllDoctors() {
        return new ResponseEntity<>(userService.getAllDoctors(), HttpStatus.ACCEPTED);
    }

    @GetMapping("user_with_biggest_expenses")
    public ResponseEntity<?> getUserWithBiggestExpenses() {
        return new ResponseEntity<>(userService.getUserWithBiggestExpenses(), HttpStatus.ACCEPTED);
    }

}
//localhost:4205/user
//localhost:4205/user/login
