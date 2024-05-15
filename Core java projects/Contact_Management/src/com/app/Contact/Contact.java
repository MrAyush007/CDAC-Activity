package com.app.Contact;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {
	private String number;
	private String name;
	private String email;
	private LocalDate dob;
	
	
	public Contact(String number, String name,LocalDate dob, String email) {
		super();
		this.number = number;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}


	@Override
	public int hashCode() {
		System.out.println("in hash");
		return 17*(name.hashCode()*dob.hashCode());
	}


	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Contact) {
			System.out.println("in equal");
			Contact c = ((Contact)obj);
			return (this.number.equals(c.number) && this.dob.equals(c.dob));
		}
		return false;	
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


	public String getNumber() {
		return number;
	}


	public LocalDate getDob() {
		return dob;
	}


	@Override
	public String toString() {
		return "Contact [number=" + number + ", name=" + name + ", email=" + email + ", dob=" + dob + "]";
	}
	
	
	
}
