package com.app.entities;

import java.sql.Date;
import java.sql.Time;

import com.app.utils.Specialization;

public class Doctor {
	private int id;
	private String name;
	private Specialization specialization;
	
	public Doctor(int id, String name, Specialization specialization) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
	}

	public Doctor(String name, Specialization specialization, Time time, Date date) {
		super();
		this.name = name;
		this.specialization = specialization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
	}
	
	
}
