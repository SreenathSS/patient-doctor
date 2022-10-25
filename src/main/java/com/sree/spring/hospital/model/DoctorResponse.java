package com.sree.spring.hospital.model;

import java.util.Set;

public class DoctorResponse {
	private Long doctorId;

    private String firstName;

    private String lastName;
    
    private String department;
    
    private Set<PatientResponse> patients;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<PatientResponse> getPatients() {
		return patients;
	}

	public void setPatients(Set<PatientResponse> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "DoctorResponse [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", patients=" + patients + "]";
	}

	
    
}
