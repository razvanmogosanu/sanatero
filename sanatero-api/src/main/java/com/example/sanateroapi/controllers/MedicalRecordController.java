package com.example.sanateroapi.controllers;

import com.example.sanateroapi.models.MedicalRecord;
import com.example.sanateroapi.services.MedicalService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("medical_record")
@CrossOrigin
public class MedicalRecordController {
    private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);
    private final MedicalService medicalService;

    public MedicalRecordController(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("addMedicalRecord {baseURL + /medical_record/add}");

        if (medicalRecord == null) {
            logger.error("Add medical record with empty body");
            return new ResponseEntity<>("Body is empty",HttpStatus.BAD_REQUEST);
        }

        this.medicalService.addMedicalRecord(medicalRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
