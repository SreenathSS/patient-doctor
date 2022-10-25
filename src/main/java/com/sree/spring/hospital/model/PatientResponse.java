package com.sree.spring.hospital.model;

import javax.persistence.Column;

public class PatientResponse {
	private Long patientId;

    private String firstName;

    private String lastName;
    
    private DoctorDTO doctor;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "PatientResponse [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", doctor=" + doctor + "]";
	}

	
    
}
