package com.app.ValidateClass;

import com.app.Exception.ContactException;

public class Validate {
	public static String validNumber(String s) throws ContactException {
		String reg=("^(0/91)?[7-9][0-9]{9}");
		if(s.matches(reg))
			return s;
		throw new ContactException("Please enter the valid phone number");
	}
	
	public static String validemail(String a) throws ContactException {

		String emailreg = "^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+(com|org|net)$";

		if (a.matches(emailreg))
			return a;
		throw new ContactException("e-mail wrong format");
	}
	public static void addException(boolean a) throws ContactException {

		if(a==false)
		throw new ContactException("Contact already Existedd!!!");
	}
	
	
}
