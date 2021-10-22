package com.plasmit.appointment.controller;

import com.plasmit.appointment.model.DoctorSchedule;
import com.plasmit.appointment.model.PatientAppointment;

public class MyDTO {
	
	private PatientAppointment patientAppointment;
	private DoctorSchedule doctorSchedule;
	public PatientAppointment getPatientAppointment() {
		return patientAppointment;
	}
	public void setPatientAppointment(PatientAppointment patientAppointment) {
		this.patientAppointment = patientAppointment;
	}
	public DoctorSchedule getDoctorSchedule() {
		return doctorSchedule;
	}
	public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
		this.doctorSchedule = doctorSchedule;
	}

}
