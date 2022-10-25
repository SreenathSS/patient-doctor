package com.sree.spring.hospital.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.spring.hospital.model.Doctor;
import com.sree.spring.hospital.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

	public static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDocs() {
		logger.debug("Returning list of all the doctors.");

		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		logger.debug("Save doctor with values {}.", doctor);

		return this.doctorRepository.save(doctor);
	}

	@Override
	public Optional<Doctor> findById(long id) {
		return this.doctorRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		this.doctorRepository.deleteById(id);
	}

}
