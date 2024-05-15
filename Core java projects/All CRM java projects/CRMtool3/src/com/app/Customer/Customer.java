package com.app.Customer;

import java.io.Serializable;
import java.time.LocalDate;


import com.app.Plan.Service;


public class Customer implements Serializable{
	private int idd;
	private static int id ; 
	private String fname, lname, email, pswd;
	private double regamt;
	private LocalDate dob;
	private Service sname;
	
	

	static {
		id =1;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + idd + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pswd=" + pswd
				+ ", regamt=" + regamt + ", dob=" + dob + ", sname=" + sname + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public double getRegamt() {
		return regamt;
	}
	public void setRegamt(double regamt) {
		this.regamt = regamt;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public static int inc(int a) {
		return a++; 
	} 
	public Customer(String fname, String lname, String email, String pswd, double regamt, LocalDate dob,
			Service sname) {
		super();
		this.idd = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pswd = pswd;
		this.regamt = regamt;
		this.dob = dob;
		this.sname = sname;
		
		id++ ;
	}
	public Customer(String s) {
		this.email=s;
	}
	public Customer(String s,LocalDate d) {
		this.email=s;
		this.dob=d;
	}
	public Service getSname() {
		return sname;
	}
	public void setSname(Service sname) {
		this.sname = sname;
	}
//	public void setnull() {
////		this.idd = null;
//		this.fname = null;
//		this.lname = null;
//		this.email = null;
//		this.pswd = null;
////		this.regamt = null;
//		this.dob = null;
//		this.sname = null;
//	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer) {
			Customer customer =((Customer)obj);
//			boolean check = (this.email.equals(customer.email) && this.dob.equals(customer.dob));
//			System.out.println(check);
//			return check;
			return this.email.equals(customer.email);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return email.hashCode();
	}
}
