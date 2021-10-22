package com.plasmit.appointment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.PatientNotFoundException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.DoctorSchedule;
import com.plasmit.appointment.model.PatientAppointment;


@Service
@Transactional
public class AppointmentControllerServiceImpl implements AppointmentControllerService{
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentControllerServiceImpl.class);
	
	@Autowired
	PatientAppointmentService patientAppointmentService;
	
	@Autowired
	DoctorScheduleService doctorScheduleService;

	@Override
	public void bookAppointment(PatientAppointment patientAppointment, DoctorSchedule doctorSchedule) {
		// TODO Auto-generated method stub
		try {
			patientAppointmentService.savePatientAppointment(patientAppointment);
			doctorScheduleService.saveDoctorSchedule(doctorSchedule);
			logger.info(" bookAppointment()<--AppointmentControllerServiceImpl -- executed");
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
		
	}

	@Override
	public void cancelAppointment(PatientAppointment patientAppointment, DoctorSchedule doctorSchedule) {
		// TODO Auto-generated method stub
		try {
			patientAppointmentService.deletePatientAppointmentById(patientAppointment.getAppid());
			doctorScheduleService.deleteDoctorScheduleById(doctorSchedule.getAppid());
			logger.info(" cancelAppointment()<--AppointmentControllerServiceImpl -- executed");
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
