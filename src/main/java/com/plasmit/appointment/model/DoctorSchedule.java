package com.plasmit.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctorschedule3")
public class DoctorSchedule {
	
	@Id
	@GeneratedValue
	private Integer appid;
	private String did;
	private String dname;
	
	public DoctorSchedule() {
	}
	public DoctorSchedule(Integer appid, String did, String dname) {
		super();
		this.appid = appid;
		this.did = did;
		this.dname = dname;
	}
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

}
