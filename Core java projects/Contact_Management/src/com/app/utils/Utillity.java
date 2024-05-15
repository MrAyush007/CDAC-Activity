package com.app.utils;

import java.time.LocalDate;
import java.util.Set;

import com.app.Contact.Contact;
import com.app.Exception.ContactException;
import com.app.ValidateClass.Validate;

public class Utillity {
	public static Contact addNumber(String number,String name,String dob,String email) throws ContactException {
		LocalDate date = LocalDate.parse(dob);
		String newEmail = Validate.validemail(email);
		String newNum = Validate.validNumber(number);
		return new Contact(newNum,name,date,newEmail);
	}	
}
