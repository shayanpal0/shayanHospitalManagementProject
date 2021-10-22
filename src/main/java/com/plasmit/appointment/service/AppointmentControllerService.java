package com.plasmit.appointment.service;

import com.plasmit.appointment.model.DoctorSchedule;
import com.plasmit.appointment.model.PatientAppointment;

public interface AppointmentControllerService {
	
	public void bookAppointment(PatientAppointment patientAppointment,DoctorSchedule doctorSchedule);
	public void cancelAppointment(PatientAppointment patientAppointment,DoctorSchedule doctorSchedule);

}
