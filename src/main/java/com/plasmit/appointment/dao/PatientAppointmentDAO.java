package com.plasmit.appointment.dao;

import java.util.List;

import com.plasmit.appointment.model.PatientAppointment;

public interface PatientAppointmentDAO {
	
	List<PatientAppointment> getAllPatientsAppointments();
	PatientAppointment findPatientsAppointmentById(int theId);
	PatientAppointment savePatientAppointment(PatientAppointment patientappointment);
	void deletePatientAppointmentById(int theId);


}
