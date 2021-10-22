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
import com.plasmit.appointment.model.DoctorSchedule;


@Repository
public class DoctorScheduleDAOImpl implements DoctorScheduleDAO{
	
private static final Logger logger = LoggerFactory.getLogger(DoctorScheduleDAOImpl.class);
	
	private EntityManager entityManager;
	
	
	@Autowired
	public DoctorScheduleDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<DoctorSchedule> getAllDoctorSchedule() {
		try {
			Query theQuery= (Query) entityManager.createQuery("from DoctorSchedule");
			List<DoctorSchedule> doctorSchedule = theQuery.getResultList();
			logger.info("getAllDoctorSchedule()<--DoctorScheduleDAOImpl class executed");
			return doctorSchedule;
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
	public DoctorSchedule findDoctorScheduleById(int theId) {
		try {
			DoctorSchedule doctorSchedule = entityManager.find(DoctorSchedule.class, theId);
			logger.info("findDoctorScheduleById()<--DoctorScheduleDAOImpl class executed");
			return doctorSchedule;
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
	public DoctorSchedule saveDoctorSchedule(DoctorSchedule doctorSchedule) {
		try {
			DoctorSchedule dbdoctorSchedule=entityManager.merge(doctorSchedule);
			doctorSchedule.setAppid(dbdoctorSchedule.getAppid());
			logger.info("saveDoctorSchedule()<--DoctorScheduleDAOImpl class executed");
			return doctorSchedule;
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
	public void deleteDoctorScheduleById(int theId) {
		try {
			Query theQuery = (Query) entityManager.createQuery("delete from DoctorSchedule where appid=:theId");
			theQuery.setParameter("theId", theId);
			theQuery.executeUpdate();
			logger.info("deleteDoctorScheduleById()<--DoctorScheduleDAOImpl class executed");
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
