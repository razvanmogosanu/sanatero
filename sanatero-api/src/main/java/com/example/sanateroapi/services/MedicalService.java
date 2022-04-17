package com.example.sanateroapi.services;

import com.example.sanateroapi.models.MedicalRecord;
import com.example.sanateroapi.repositories.MedicalAssistanceRepository;
import com.example.sanateroapi.repositories.MedicalRecordRepository;
import com.example.sanateroapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final UserRepository userRepository;
    private final MedicalAssistanceRepository medicalAssistanceRepository;

    public MedicalService(MedicalRecordRepository medicalRecordRepository, UserRepository userRepository, MedicalAssistanceRepository medicalAssistanceRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.userRepository = userRepository;
        this.medicalAssistanceRepository = medicalAssistanceRepository;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecord.setCaregiver(userRepository.getByUsername(medicalRecord.getCaregiver().getUsername()).get());
        medicalRecord.setPatient(userRepository.getByUsername(medicalRecord.getPatient().getUsername()).get());
        medicalRecord.setMedicalAssistance(medicalAssistanceRepository.getByName(medicalRecord.getMedicalAssistance().getName()).get());
        medicalRecordRepository.save(medicalRecord);
    }

}
