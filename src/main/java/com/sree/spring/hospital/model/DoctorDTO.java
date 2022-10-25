package com.sree.spring.hospital.model;

public class DoctorDTO {
	private String firstName;

    private String lastName;
    
    private String department;

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

	@Override
	public String toString() {
		return "DoctorDTO [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + "]";
	}
    
    
}
