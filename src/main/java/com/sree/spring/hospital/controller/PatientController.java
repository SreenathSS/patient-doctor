package com.sree.spring.hospital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sree.spring.hospital.model.DoctorDTO;
import com.sree.spring.hospital.model.Patient;
import com.sree.spring.hospital.model.PatientDTO;
import com.sree.spring.hospital.model.PatientResponse;
import com.sree.spring.hospital.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PatientController {

	public static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping(value = "/patients", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PatientResponse>> getAllPatients() {
		logger.info("Inside getall patients");

		List<Patient> patientsList = new ArrayList<>();
		List<PatientResponse> responseList = new ArrayList<>();

		patientsList = patientService.getAllPatients();
		if (patientsList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		for (Patient p : patientsList) {
			PatientResponse response = new PatientResponse();
			response.setFirstName(p.getFirstName());
			response.setLastName(p.getLastName());
			response.setPatientId(p.getPatientId());

			DoctorDTO doctor = new DoctorDTO();

			if (p.getDoctor() != null) {
				doctor.setDepartment(p.getDoctor().getDepartment());
				doctor.setFirstName(p.getDoctor().getFirstName());
				doctor.setLastName(p.getDoctor().getLastName());
			}

			response.setDoctor(doctor);
			responseList.add(response);
		}

		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

	@GetMapping(value="/patients/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PatientResponse> getTutorialById(@PathVariable("id") long id) {
		logger.info("Inside get patient by ID");

		Optional<Patient> patient = patientService.findById(id);
		if (patient.isPresent()) {

			PatientResponse response = new PatientResponse();
			response.setFirstName(patient.get().getFirstName());
			response.setLastName(patient.get().getLastName());
			response.setPatientId(patient.get().getPatientId());

			DoctorDTO doctor = new DoctorDTO();

			if (patient.get().getDoctor() != null) {
				doctor.setDepartment(patient.get().getDoctor().getDepartment());
				doctor.setFirstName(patient.get().getDoctor().getFirstName());
				doctor.setLastName(patient.get().getDoctor().getLastName());
			}

			response.setDoctor(doctor);
			return new ResponseEntity<>(response, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		}

	}

	@PutMapping(value="/patients/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePatient(@PathVariable("id") long id, @RequestBody PatientDTO patientDTO) {
		logger.info("Inside update patient");

		Optional<Patient> patientOp = patientService.findById(id);
		if (patientOp.isPresent()) {
			Patient patient = patientOp.get();
			patient.setFirstName(patientDTO.getFirstName());
			patient.setLastName(patientDTO.getLastName());
			patientService.savePatient(patient);

			return new ResponseEntity<>("Success", HttpStatus.OK);
		}

		return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/patients", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient createPatient(@RequestBody Patient patient) {
		logger.info("Creating Patient : {}", patient);

		return patientService.savePatient(patient);
	}
	
	@DeleteMapping(value="/patients/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
		logger.info("Inside delete patient");

		patientService.deleteById(id);

		return new ResponseEntity<>("Success",HttpStatus.NO_CONTENT);
	}
}
