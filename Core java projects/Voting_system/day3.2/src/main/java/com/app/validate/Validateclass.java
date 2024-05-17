package com.app.validate;

import java.time.LocalDate;
import java.time.Period;

public class Validateclass {

	public static LocalDate validate(LocalDate dob) {
		Period hh = Period.between(dob, LocalDate.now());
		if(hh.getYears()<21)
		{
			return null;
		}
		return dob;
	}
}
