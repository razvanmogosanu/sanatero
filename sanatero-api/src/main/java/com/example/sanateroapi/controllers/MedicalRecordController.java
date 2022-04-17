package com.example.sanateroapi.controllers;

import com.example.sanateroapi.models.MedicalRecord;
import com.example.sanateroapi.services.MedicalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medical_record")
@CrossOrigin
public class MedicalRecordController {
    private final MedicalService medicalService;

    public MedicalRecordController(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        this.medicalService.addMedicalRecord(medicalRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
