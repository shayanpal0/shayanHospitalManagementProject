package com.plasmit.appointment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.Patient;
import com.plasmit.appointment.service.PatientService;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;

	public PatientController(PatientService thePatientService) {
		super();
		this.patientService = thePatientService;
	}
	
	@RequestMapping(value = "/getall", method= RequestMethod.GET)
    public ResponseEntity<List<Patient>> findAll(){
		ResponseEntity<List<Patient>> response=null;
		try {
			response=new ResponseEntity<List<Patient>>(patientService.findAllPatients(), HttpStatus.OK);
		    if (response==null) 
		    	throw new PatientNotFoundException("Patient Not Found");
		    
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
		return response;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Patient addPatient(@RequestBody Patient thepatient){
		try {
			patientService.savePatient(thepatient);
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
		return thepatient;
	}
	
	@RequestMapping(value = "/delete/{patientId}", method = RequestMethod.DELETE)
    public String deletePatient(@PathVariable int patientId){
		try {
			patientService.deletePatientById(patientId);
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
		return "deleted transaction id " + patientId;
	}
	
	@RequestMapping(value = "/getone/{patientId}", method = RequestMethod.GET)
	public Patient findPatientsById(@PathVariable int patientId) {
		Patient tempPatient = null;
		try {
			tempPatient = patientService.findPatientsById(patientId);
			if (tempPatient==null) 
		    	throw new PatientNotFoundException("Patient Not Found");
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

}
