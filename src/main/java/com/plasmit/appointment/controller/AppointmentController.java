package com.plasmit.appointment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.service.AppointmentControllerService;
import com.plasmit.appointment.service.DoctorScheduleService;
import com.plasmit.appointment.service.PatientAppointmentService;

@RestController
@RequestMapping(value="/appointment")
public class AppointmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	private PatientAppointmentService patientAppointmentService;
	
	@Autowired
	private DoctorScheduleService doctorScheduleService;
	
	@Autowired
	private AppointmentControllerService mainControllerService;

	public AppointmentController(AppointmentControllerService mainControllerService) {
		super();
		this.mainControllerService = mainControllerService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveAppointment(@RequestBody MyDTO dto){
		try {
			patientAppointmentService.savePatientAppointment(dto.getPatientAppointment());
			doctorScheduleService.saveDoctorSchedule(dto.getDoctorSchedule());
			logger.info("saveAppointment<--AppointmentController class executed");
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
		//doctorScheduleService.saveDoctorSchedule(null);
		return "Saved appointment";
		
	}
	
	@RequestMapping(value="/delete/{appid}",method=RequestMethod.DELETE)
	public void deleteAppointment(@PathVariable int appid) {
		try {
			patientAppointmentService.deletePatientAppointmentById(appid);
			doctorScheduleService.deleteDoctorScheduleById(appid+1);
			//mainControllerService.cancelAppointment(dto.getPatientAppointment(), dto.getDoctorSchedule());
			//return "Deleted Appointment";
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
