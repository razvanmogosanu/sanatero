package com.example.sanateroapi.repositories;

import com.example.sanateroapi.models.MedicalAssistance;
import com.example.sanateroapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalAssistanceRepository extends JpaRepository<MedicalAssistance, Integer> {

    @Query(nativeQuery = true, value = "call sanatero.get_all_medical_assistances()")
    List<MedicalAssistance> getAllMedicalAssistance();

    Optional<MedicalAssistance> getByName(String name);
}
