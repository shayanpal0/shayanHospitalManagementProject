package com.plasmit.appointment.dao;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plasmit.appointment.model.PatientAppointment;

@Repository
public class PatientAppointmentDAOImpl implements PatientAppointmentDAO{
	
private EntityManager entityManager;
	
	@Autowired
    public PatientAppointmentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

	@Override
	public List<PatientAppointment> getAllPatientsAppointments() {
		Query theQuery= (Query) entityManager.createQuery("from PatientAppointment");
		List<PatientAppointment> patientappointmnets = theQuery.getResultList();
		return patientappointmnets;
	}

	@Override
	public PatientAppointment findPatientsAppointmentById(int theId) {
		PatientAppointment patientAppointment = entityManager.find(PatientAppointment.class, theId);
		return patientAppointment;
	}

	@Override
	public PatientAppointment savePatientAppointment(PatientAppointment patientappointment) {
		PatientAppointment dbpatientAppointment=entityManager.merge(patientappointment);
		patientappointment.setAppid(dbpatientAppointment.getAppid());
		return patientappointment;
	}

	@Override
	public void deletePatientAppointmentById(int theId) {
		Query theQuery = (Query) entityManager.createQuery("delete from PatientAppointment where appid=:theId");
		theQuery.setParameter("theId", theId);
		theQuery.executeUpdate();
		
	}


}
