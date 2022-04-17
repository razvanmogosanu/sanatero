package com.example.sanateroapi.repositories;

import com.example.sanateroapi.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository  extends JpaRepository<MedicalRecord, Integer> {

}
