package com.plasmit.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patientappointment3")
public class PatientAppointment {
	
	
	@Id
	@GeneratedValue
	private Integer appid;
	private Integer pid;
	private String pname;
	
	public PatientAppointment() {
	}
	public PatientAppointment(Integer appid,Integer pid, String pname) {
		super();
		this.appid=appid;
		this.pid = pid;
		this.pname = pname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	@Override
	public String toString() {
		return "PatientAppointment [appid=" + appid + ", pid=" + pid + ", pname=" + pname + "]";
	}

}
