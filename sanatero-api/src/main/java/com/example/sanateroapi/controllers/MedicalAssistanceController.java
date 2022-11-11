package com.example.sanateroapi.controllers;

import com.example.sanateroapi.services.MedicalAssistanceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(MedicalAssistanceController.class);
    private final MedicalAssistanceService medicalAssistanceService;

    public MedicalAssistanceController(MedicalAssistanceService medicalAssistanceService) {
        this.medicalAssistanceService = medicalAssistanceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllMedicalAssistance() {
        logger.info("getAllMedicalAssistance {baseURL + /assistance}");
        return new ResponseEntity<>(this.medicalAssistanceService.getAllMedicalAssistance(), HttpStatus.OK);
    }
}
