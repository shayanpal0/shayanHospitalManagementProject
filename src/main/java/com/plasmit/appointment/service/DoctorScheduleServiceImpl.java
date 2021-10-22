package com.plasmit.appointment.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plasmit.appointment.dao.DoctorScheduleDAO;
import com.plasmit.appointment.exception.BusinessException;
import com.plasmit.appointment.exception.UnauthorizedException;
import com.plasmit.appointment.model.DoctorSchedule;


@Service
@Transactional
public class DoctorScheduleServiceImpl implements DoctorScheduleService{
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorScheduleServiceImpl.class);
	
	DoctorScheduleDAO doctorScheduleDAO;
	
	
	@Autowired
	public DoctorScheduleServiceImpl(@Qualifier("doctorScheduleDAOImpl")DoctorScheduleDAO doctorScheduleDAO) {
		super();
		this.doctorScheduleDAO = doctorScheduleDAO;
	}

	@Override
	@Transactional
	public List<DoctorSchedule> getAllDoctorSchedule() {
		List<DoctorSchedule> tempDoctorSchedule = null;
		try {
			tempDoctorSchedule = doctorScheduleDAO.getAllDoctorSchedule();
			logger.info("getAllDoctorSchedule() executed");
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
		//return doctorScheduleDAO.getAllDoctorSchedule();
		return tempDoctorSchedule;
	}

	@Override
	@Transactional
	public DoctorSchedule findDoctorScheduleById(int theId) {
		DoctorSchedule tempDoctorSchedule=null;
		try {
			tempDoctorSchedule=doctorScheduleDAO.findDoctorScheduleById(theId);
			logger.info("findDoctorScheduleById() executed");
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
		return tempDoctorSchedule;
	}

	@Override
	@Transactional
	public DoctorSchedule saveDoctorSchedule(DoctorSchedule doctorSchedule) {
		DoctorSchedule tempDoctorSchedule=null;
		try {
			tempDoctorSchedule=doctorScheduleDAO.saveDoctorSchedule(doctorSchedule);
			logger.info("saveDoctorSchedule() executed");
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
		return tempDoctorSchedule;
	}

	@Override
	@Transactional
	public void deleteDoctorScheduleById(int theId) {
		try {
			doctorScheduleDAO.deleteDoctorScheduleById(theId);
			logger.info("deleteDoctorScheduleById() executed");
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
