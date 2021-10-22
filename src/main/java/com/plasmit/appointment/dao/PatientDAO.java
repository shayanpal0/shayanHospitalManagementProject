package com.plasmit.appointment.dao;

import java.util.List;

import com.plasmit.appointment.model.Patient;

public interface PatientDAO {
	
	List<Patient> getAllPatients();
	Patient findPatientsById(int theId);
	Patient savePatient(Patient patient);
	void deletePatientById(int theId);

}
