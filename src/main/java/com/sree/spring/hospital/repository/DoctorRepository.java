package com.sree.spring.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sree.spring.hospital.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
