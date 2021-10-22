package com.plasmit.appointment.service;

import java.util.List;

import com.plasmit.appointment.model.PatientAppointment;

public interface PatientAppointmentService {
	
	public List<PatientAppointment> getAllPatientsAppointments();
	public PatientAppointment findPatientsAppointmentById(int theId);
	public PatientAppointment savePatientAppointment(PatientAppointment patientappointment);
	public void deletePatientAppointmentById(int theId);


}
