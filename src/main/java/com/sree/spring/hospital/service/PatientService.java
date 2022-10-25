package com.sree.spring.hospital.service;


import java.util.List;
import java.util.Optional;

import com.sree.spring.hospital.model.Patient;

public interface PatientService {

	List<Patient> getAllPatients();

    Patient savePatient(Patient diseases);
    
    Optional<Patient> findById(long id);
    
    void deleteById(long id);
}
