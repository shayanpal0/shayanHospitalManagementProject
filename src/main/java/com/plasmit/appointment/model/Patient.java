package com.plasmit.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient2")
public class Patient {
	
	@Id
	@GeneratedValue
	private Integer pid;
	private String name;
	
	
	public Patient() {
	}
	
	public Patient(Integer pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
