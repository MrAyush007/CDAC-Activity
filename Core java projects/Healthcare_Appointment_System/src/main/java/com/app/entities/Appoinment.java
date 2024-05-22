package com.app.entities;

import java.sql.Date;
import java.sql.Time;

public class Appoinment {
	    private int appointmentId;
	    private int patientId;
	    private int doctorId;
	    private Date appointmentDate;
	    private Time appointmentTime;
	    private String name ;
	    
	    
	    
	    
	    
		public Appoinment(int appointmentId, int patientId, int doctorId, Date appointmentDate, Time appointmentTime,String name) {
			super();
			this.appointmentId = appointmentId;
			this.patientId = patientId;
			this.doctorId = doctorId;
			this.appointmentDate = appointmentDate;
			this.appointmentTime = appointmentTime;
			this.name= name;
		}
		
		
		
		
		public Appoinment(int patientId, int doctorId, Date appointmentDate, Time appointmentTime,String name) {
			super();
			this.patientId = patientId;
			this.doctorId = doctorId;
			this.appointmentDate = appointmentDate;
			this.appointmentTime = appointmentTime;
			this.name= name;
		}




		public int getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		public int getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}
		public Date getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(Date appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public Time getAppointmentTime() {
			return appointmentTime;
		}
		public void setAppointmentTime(Time appointmentTime) {
			this.appointmentTime = appointmentTime;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}




		@Override
		public String toString() {
			return "Appoinment [DoctorId=" + patientId + ", appointmentDate=" + appointmentDate + ", appointmentTime="
					+ appointmentTime + ", Doctor=" + name  + "]";
		}

	    // Constructor, getters, and setters
}
