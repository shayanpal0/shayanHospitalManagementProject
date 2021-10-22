package com.plasmit.appointment.service;

import java.util.List;

import com.plasmit.appointment.model.Doctor;

public interface DoctorService {
	
	public List<Doctor> findAllDoctors();
	public Doctor findDoctorsById(int theId);
	public Doctor saveDoctor(Doctor doctor);
	public int deleteDoctorById(int theId);

}
