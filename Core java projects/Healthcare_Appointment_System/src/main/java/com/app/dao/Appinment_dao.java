package com.app.dao;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import com.app.entities.Appoinment;

public interface Appinment_dao {
	// to show all appoinments
	List<Appoinment> showPatientAppoinments(String email) throws SQLException;

	// to delete from the appoinment table
	boolean deleteAppoinment(int num) throws SQLException;

	// to add an appoinment
	boolean addAppoinment(Appoinment a1) throws SQLException;

	// to add an appoinment
	List<LocalTime> timeList() throws SQLException;
}
