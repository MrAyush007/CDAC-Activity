package com.app.dao;

import java.sql.SQLException;

import com.app.entities.Patient;

public interface patient_dao  {
//		for patient sign in
		Patient signIn(String email,String pass) throws SQLException;
//		for registration patient
		String patientRegister(Patient p1) throws SQLException;
//		
}
