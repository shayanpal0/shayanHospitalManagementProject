package com.plasmit.appointment.dao;

import java.util.List;

import com.plasmit.appointment.model.Doctor;

public interface DoctorDAO {
	
	List<Doctor> getAllDoctors();
	Doctor findDoctorsById(int theId);
	Doctor saveDoctor(Doctor doctor);
	void deleteDoctorById(int theId);

}
