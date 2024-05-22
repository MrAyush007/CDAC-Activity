package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Doctor;

public interface Doctor_dao {
	//to showw to doctor;
	List<Doctor> showDoctor() throws SQLException;
	//to find doctor with an doc_id
	String findDoctor(int doc_id) throws SQLException;
}
