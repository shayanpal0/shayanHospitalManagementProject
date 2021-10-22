package com.plasmit.appointment.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.Patient;



@Repository
public class PatientDAOImpl implements PatientDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PatientDAOImpl.class);
	
	private EntityManager entityManager;

	@Autowired
    public PatientDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

	@Override
	public List<Patient> getAllPatients() {
		try {
			Query theQuery= (Query) entityManager.createQuery("from Patient");
			List<Patient> patients = theQuery.getResultList();
			logger.info("getAllPatients()<--PatientDAOImpl class executed");
			return patients;
		}
		catch(PatientNotFoundException e) {
	         
            logger.error("Invalid Input:", e.getMessage());
            throw new PatientNotFoundException("Patient not found");
            //response = new ResponseEntity<List<Patient>>(patientService.findAllPatients(), HttpStatus.NOT_FOUND);

        }
		catch(BusinessException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Business Exception:", e.getMessage());
            throw new BusinessException("Server error");
		}
		catch(UnauthorizedException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Unauthorized Exception:", e.getMessage());
            throw new UnauthorizedException("Validation failed");
		}
	}

	@Override
	public Patient findPatientsById(int theId) {
		try {
			Patient thePatient = entityManager.find(Patient.class,theId);
			logger.info("findPatientsById()<--PatientDAOImpl class executed");
			return thePatient;
		}
		catch(PatientNotFoundException e) {
	         
            logger.error("Invalid Input:", e.getMessage());
            throw new PatientNotFoundException("Patient not found");
            //response = new ResponseEntity<List<Patient>>(patientService.findAllPatients(), HttpStatus.NOT_FOUND);

        }
		catch(BusinessException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Business Exception:", e.getMessage());
            throw new BusinessException("Server error");
		}
		catch(UnauthorizedException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Unauthorized Exception:", e.getMessage());
            throw new UnauthorizedException("Validation failed");
		}
	}

	@Override
	public Patient savePatient(Patient patient) {
		try {
			Patient dbPatient = entityManager.merge(patient);
			patient.setPid(dbPatient.getPid());
			logger.info("savePatient()<--PatientDAOImpl class executed");
			return patient;
		}
		catch(PatientNotFoundException e) {
	         
            logger.error("Invalid Input:", e.getMessage());
            throw new PatientNotFoundException("Patient not found");
            //response = new ResponseEntity<List<Patient>>(patientService.findAllPatients(), HttpStatus.NOT_FOUND);

        }
		catch(BusinessException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Business Exception:", e.getMessage());
            throw new BusinessException("Server error");
		}
		catch(UnauthorizedException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Unauthorized Exception:", e.getMessage());
            throw new UnauthorizedException("Validation failed");
		}
		
	}

	@Override
	public void deletePatientById(int theId) {
		try {
			Query theQuery = (Query) entityManager.createQuery("delete from Patient where pid=:patientId");
			theQuery.setParameter("patientId", theId);
	        theQuery.executeUpdate();
		}
		catch(PatientNotFoundException e) {
	         
            logger.error("Invalid Input:", e.getMessage());
            throw new PatientNotFoundException("Patient not found");
            //response = new ResponseEntity<List<Patient>>(patientService.findAllPatients(), HttpStatus.NOT_FOUND);

        }
		catch(BusinessException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Business Exception:", e.getMessage());
            throw new BusinessException("Server error");
		}
		catch(UnauthorizedException e) {
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Unauthorized Exception:", e.getMessage());
            throw new UnauthorizedException("Validation failed");
		}
		
	}

}

