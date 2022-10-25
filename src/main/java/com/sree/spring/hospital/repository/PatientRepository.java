package com.sree.spring.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sree.spring.hospital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
