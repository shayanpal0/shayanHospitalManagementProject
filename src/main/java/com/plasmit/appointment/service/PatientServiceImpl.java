package com.plasmit.appointment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plasmit.appointment.dao.PatientDAO;
import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.Patient;


@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	
private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	PatientDAO patientDAO;

	@Autowired
    public PatientServiceImpl(@Qualifier("patientDAOImpl") PatientDAO thePatientDao){
        patientDAO = thePatientDao;
    }

	@Override
	public List<Patient> findAllPatients() {
		List<Patient> tempPatient=null;
		try {
			tempPatient=patientDAO.getAllPatients();
			if (tempPatient==null)throw new PatientNotFoundException("Doctors Not Found");
			logger.info("findAllPatients()<--PatientServiceImpl class executed");
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
		return tempPatient;
	}

	@Override
	public Patient findPatientsById(int theId) {
		Patient tempPatient = null;
		try {
			tempPatient = patientDAO.findPatientsById(theId);
			if (tempPatient==null)throw new PatientNotFoundException("Doctors Not Found");
			logger.info("findPatientsById()<--PatientServiceImpl class executed");
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
		return tempPatient;
	}

	@Override
	public Patient savePatient(Patient patient) {
		Patient tempPatient = null;
		try {
			tempPatient = patientDAO.savePatient(patient);
			logger.info("savePatient()<--PatientServiceImpl class executed");
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
		return tempPatient;
	}

	@Override
	public int deletePatientById(int theId) {
		try {
			patientDAO.deletePatientById(theId);
			logger.info("deletePatientById()<--PatientServiceImpl class executed");
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
		return theId;
	}
	
	

}
