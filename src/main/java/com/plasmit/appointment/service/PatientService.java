package com.plasmit.appointment.service;

import java.util.List;

import com.plasmit.appointment.model.Patient;

public interface PatientService {
	
	public List<Patient> findAllPatients();
	public Patient findPatientsById(int theId);
	public Patient savePatient(Patient patient);
	public int deletePatientById(int theId);

}
