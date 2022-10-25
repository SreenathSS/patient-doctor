package com.sree.spring.hospital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sree.spring.hospital.model.Doctor;
import com.sree.spring.hospital.model.DoctorDTO;
import com.sree.spring.hospital.model.DoctorResponse;
import com.sree.spring.hospital.model.Patient;
import com.sree.spring.hospital.model.PatientResponse;
import com.sree.spring.hospital.service.DoctorService;
import com.sree.spring.hospital.service.PatientService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/v1")
public class DoctorController {

	public static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	private DoctorService doctorService;

	private PatientService patientService;

	public DoctorController(DoctorService doctorService, PatientService patientService) {
		this.doctorService = doctorService;
		this.patientService = patientService;
	}

	@GetMapping(value = "/doctors", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		logger.info("Inside getall doctors");
		List<Doctor> doctorsList = new ArrayList<Doctor>();

		doctorsList = doctorService.getAllDocs();
		if (doctorsList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(doctorsList, HttpStatus.OK);
	}

	@PostMapping(value = "/doctors", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		logger.info("Inside create doctors");

		return doctorService.saveDoctor(doctor);
	}

	@PutMapping(value="/doctors/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePatient(@PathVariable("id") long id, @RequestBody DoctorDTO doctorDTO) {
		logger.info("Inside update doctor by ID");

		Optional<Doctor> doctorOp = doctorService.findById(id);
		if (doctorOp.isPresent()) {
			Doctor doctor = doctorOp.get();
			doctor.setFirstName(doctorDTO.getFirstName());
			doctor.setLastName(doctorDTO.getLastName());
			doctor.setDepartment(doctorDTO.getDepartment());

			doctorService.saveDoctor(doctor);

			return new ResponseEntity<>("Success", HttpStatus.OK);
		}

		return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping(value="/doctors/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DoctorResponse> getTutorialById(@PathVariable("id") long id) {
		logger.info("Inside get doctor by ID");
		Optional<Doctor> doctor = doctorService.findById(id);
		if (doctor.isPresent()) {
			DoctorResponse response = new DoctorResponse();
			response.setFirstName(doctor.get().getFirstName());
			response.setLastName(doctor.get().getLastName());
			response.setDoctorId(doctor.get().getDoctorId());
			response.setDepartment(doctor.get().getDepartment());

			Set<PatientResponse> patientsSet = new HashSet<PatientResponse>();

			if (doctor.get().getPatients() != null) {
				for (Patient p : doctor.get().getPatients()) {
					PatientResponse patient = new PatientResponse();
					patient.setFirstName(p.getFirstName());
					patient.setLastName(p.getLastName());
					patient.setPatientId(p.getPatientId());
					patientsSet.add(patient);
				}
			}

			response.setPatients(patientsSet);
			return new ResponseEntity<>(response, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping(value="/doctors/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
		logger.info("Inside delete doctor");

		doctorService.deleteById(id);

		return new ResponseEntity<>("Success",HttpStatus.NO_CONTENT);
	}

}
