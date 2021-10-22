package com.plasmit.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor2")
public class Doctor {
	
	@Id
	@GeneratedValue
	private Integer did;
	private String dname;
	
	
	public Doctor() {
	}


	public Doctor(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}


	public Integer getDid() {
		return did;
	}


	public void setDid(Integer did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}

}
