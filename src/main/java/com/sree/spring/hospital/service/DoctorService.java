package com.sree.spring.hospital.service;

import java.util.List;
import java.util.Optional;

import com.sree.spring.hospital.model.Doctor;

public interface DoctorService {


    Doctor saveDoctor(Doctor doctor);

    List<Doctor> getAllDocs();
    
    Optional<Doctor> findById(long id);

	void deleteById(long id);
}
