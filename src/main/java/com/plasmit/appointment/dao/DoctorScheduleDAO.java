package com.plasmit.appointment.dao;

import java.util.List;

import com.plasmit.appointment.model.DoctorSchedule;

public interface DoctorScheduleDAO {
	
	List<DoctorSchedule> getAllDoctorSchedule();
	DoctorSchedule findDoctorScheduleById(int theId);
	DoctorSchedule saveDoctorSchedule(DoctorSchedule doctorSchedule);
	void deleteDoctorScheduleById(int theId);

}
