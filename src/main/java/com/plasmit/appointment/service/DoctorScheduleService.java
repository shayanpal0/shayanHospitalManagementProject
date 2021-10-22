package com.plasmit.appointment.service;

import java.util.List;

import com.plasmit.appointment.model.DoctorSchedule;

public interface DoctorScheduleService {
	
	public List<DoctorSchedule> getAllDoctorSchedule();
	public DoctorSchedule findDoctorScheduleById(int theId);
	public DoctorSchedule saveDoctorSchedule(DoctorSchedule doctorSchedule);
	public void deleteDoctorScheduleById(int theId);

}
