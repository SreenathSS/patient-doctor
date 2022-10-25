package com.sree.spring.hospital.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.spring.hospital.model.Patient;
import com.sree.spring.hospital.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

	public static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient savePatient(Patient patient) {
		logger.info("Save patient with values {}.", patient);

		return this.patientRepository.save(patient);
	}

	private boolean existsPatient(Long patientId) {
		return this.patientRepository.existsById(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {
		return this.patientRepository.findAll();
	}

	@Override
	public Optional<Patient> findById(long id) {
		return this.patientRepository.findById(id);
	}
	
	@Override
	public void deleteById(long id) {
		this.patientRepository.deleteById(id);
	}

}
