package com.plasmit.appointment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plasmit.appointment.dao.DoctorDAO;
import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.Doctor;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{
	
private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	DoctorDAO doctorDAO;
	
	
	@Autowired
	public DoctorServiceImpl(@Qualifier("doctorDAOImpl")DoctorDAO doctorDAO) {
		super();
		this.doctorDAO = doctorDAO;
	}

	@Override
	public List<Doctor> findAllDoctors() {
		List<Doctor> tempDoctor = null;
		try {
			tempDoctor=doctorDAO.getAllDoctors();
			if (tempDoctor==null)throw new PatientNotFoundException("Doctors Not Found");
			logger.info("findAllDoctors()<--DoctorServiceImpl class executed");
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
		return tempDoctor;
	}

	@Override
	public Doctor findDoctorsById(int theId) {
		Doctor temoDoctor = null;
		try {
			temoDoctor = doctorDAO.findDoctorsById(theId);
			if(temoDoctor==null)throw new PatientNotFoundException("Doctors Not Found");
			logger.info("findDoctorsById()<--DoctorServiceImpl class executed");
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
		return temoDoctor;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		Doctor temoDoctor = null;
		try {
			temoDoctor = doctorDAO.saveDoctor(doctor);
			logger.info("saveDoctor()<--DoctorServiceImpl class executed");
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
		return temoDoctor;
	}

	@Override
	public int deleteDoctorById(int theId) {
		try {
			doctorDAO.deleteDoctorById(theId);
			logger.info("deleteDoctorById()<--DoctorServiceImpl class executed");
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
