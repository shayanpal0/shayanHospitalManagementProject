package com.plasmit.appointment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.Doctor;
import com.plasmit.appointment.service.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	@RequestMapping(value = "/getall", method= RequestMethod.GET)
	public ResponseEntity<List<Doctor>> findAll(){
		ResponseEntity<List<Doctor>> response=null;
		try {
			 response=new ResponseEntity<List<Doctor>>(doctorService.findAllDoctors(),HttpStatus.OK);
			 if(response==null) throw new PatientNotFoundException("Patient Not Found");
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
	
	@RequestMapping(value = "/getone/{doctorid}", method = RequestMethod.GET)
	public Doctor findById(@PathVariable int doctorid) {
		Doctor temoDoctor=null;
		try {
			temoDoctor=doctorService.findDoctorsById(doctorid);	
			if(temoDoctor==null)throw new PatientNotFoundException("Patient Not Found");
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
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		try {
			doctorService.saveDoctor(doctor);
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
		
		return doctor;
		
	}
	
	@RequestMapping(value = "/delete/{doctorid}", method = RequestMethod.DELETE)
	public String deleteDoctor(@PathVariable int doctorid) {
		Doctor temoDoctor=doctorService.findDoctorsById(doctorid);
		if(temoDoctor==null) {
			logger.error("Doctor not found");
			throw new PatientNotFoundException("Not found");
		}
		try {
			doctorService.deleteDoctorById(doctorid);
		}
		catch(BusinessException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Business Exception:", e.getMessage());
            throw new BusinessException("Server error");
		}
		catch(UnauthorizedException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Unauthorized Exception:", e.getMessage());
            throw new UnauthorizedException("Validation failed");
		}
		
		return "deleted doctor "+doctorid;
	}


}
