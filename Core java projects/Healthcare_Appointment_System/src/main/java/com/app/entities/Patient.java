package com.app.entities;

import java.sql.Date;

import java.sql.Time;

public class Patient {
	private int id;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private String role;
	
	public Patient(int id, String name, String email, String password, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role="patient";
	}
	
	
	public Patient(String name, String email, String password, Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ ", role=" + role + "]";
	}
	
	
	
 }
