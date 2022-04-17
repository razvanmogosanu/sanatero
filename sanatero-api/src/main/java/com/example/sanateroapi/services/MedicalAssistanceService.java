package com.example.sanateroapi.services;

import com.example.sanateroapi.models.MedicalAssistance;
import com.example.sanateroapi.repositories.MedicalAssistanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalAssistanceService {
    private final MedicalAssistanceRepository medicalAssistanceRepository;

    public MedicalAssistanceService(MedicalAssistanceRepository medicalAssistanceRepository) {
        this.medicalAssistanceRepository = medicalAssistanceRepository;
    }

    public List<MedicalAssistance> getAllMedicalAssistance() {
        return medicalAssistanceRepository.getAllMedicalAssistance();
    }
}
