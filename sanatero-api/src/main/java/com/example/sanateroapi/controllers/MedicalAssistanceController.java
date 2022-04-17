package com.example.sanateroapi.controllers;

import com.example.sanateroapi.services.MedicalAssistanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistance")
@CrossOrigin
public class MedicalAssistanceController {
    private final MedicalAssistanceService medicalAssistanceService;

    public MedicalAssistanceController(MedicalAssistanceService medicalAssistanceService) {
        this.medicalAssistanceService = medicalAssistanceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllMedicalAssistance() {
        return new ResponseEntity<>(this.medicalAssistanceService.getAllMedicalAssistance(), HttpStatus.ACCEPTED);
    }
}
