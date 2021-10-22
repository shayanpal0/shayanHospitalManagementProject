package com.plasmit.appointment.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plasmit.appointment.dao.PatientAppointmentDAO;
import com.plasmit.appointment.model.PatientAppointment;


@Service
@Transactional
public class PatientAppointmentServiceImpl implements PatientAppointmentService{
	
	PatientAppointmentDAO patientAppointmentDAO;
	
	
	@Autowired
	public PatientAppointmentServiceImpl(@Qualifier("patientAppointmentDAOImpl")PatientAppointmentDAO patientAppointmentDAO) {
		super();
		this.patientAppointmentDAO = patientAppointmentDAO;
	}

	@Override
	@Transactional
	public List<PatientAppointment> getAllPatientsAppointments() {
		return patientAppointmentDAO.getAllPatientsAppointments();
		
	}

	@Override
	@Transactional
	public PatientAppointment findPatientsAppointmentById(int theId) {
		return patientAppointmentDAO.findPatientsAppointmentById(theId);
	}

	@Override
	@Transactional
	public PatientAppointment savePatientAppointment(PatientAppointment patientappointment) {
		return patientAppointmentDAO.savePatientAppointment(patientappointment);
	
	}

	@Override
	@Transactional
	public void deletePatientAppointmentById(int theId) {
		patientAppointmentDAO.deletePatientAppointmentById(theId);
		
	}

}
