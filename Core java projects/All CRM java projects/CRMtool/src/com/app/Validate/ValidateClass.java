package com.app.Validate;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.Customer.Customer;
import com.app.Exc.Eclass;
import com.app.Plan.Service;

public class ValidateClass {
	public static Customer customervalidateinput(String fname, String lname, String email, String pass, double amt,
			String dob, String plan, List<Customer> cc) throws Eclass {
		Service t = validatePlan(plan);
		LocalDate dab = LocalDate.parse(dob);
		checkdob(dab);
		Service tt = vaildplann(t, amt);
		String newe = validemail(email);
		String nepss = validepass(pass);
//		String ee = validate_email(newe, dab, cc);
		String ee = validate_email(newe, cc);
		return new Customer(fname, lname, ee, nepss, amt, dab, tt);

	}

	public static Service validatePlan(String plan) throws Eclass {
		for (Service new_plan : Service.values()) {
			if (new_plan.name().equalsIgnoreCase(plan)) {
				return new_plan;
			}
		}
		throw new Eclass("INVALID PLAN");

	}

	public static String validate_email(String email,List<Customer> customers) throws Eclass {
		Customer cs = new Customer(email);
//		for(Customer aa : a) {
		if (customers.equals(cs)) {
			throw new Eclass("Email already existed!!!!");
//			}
		}
//		System.out.println("nottt");
		return email;
	}
	
//	public static String validate_email(String email, LocalDate date, ArrayList<Customer> customers) throws Eclass {
//		Customer cs = new Customer(email, date);
////		for(Customer aa : a) {
//		if (customers.equals(cs)) {
//			throw new Eclass("Email already existed!!!!");
////			}
//		}
////		System.out.println("nottt");
//		return email;
//	}
//	public static LocalDate validdate(String s)throws Eclass{
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		if(LocalDate.parse(s, formatter).getClass().equals(formatter))
//		}
//		return s;
//	}

	public static Service vaildplann(Service st, double p) throws Eclass {
		// convert the string to service

		if (st.getPrice() == p) {
			return st;
		}
		throw new Eclass("INVALID PLAN");
	}

	public static String validemail(String a) throws Eclass {

		String emailreg = "^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+(com|org|net)$";

		if (a.matches(emailreg))
			return a;
		throw new Eclass("e-mail wrong format");
	}

	public static String validepass(String a) throws Eclass {

		String emailreg = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";

		if (a.matches(emailreg))
			return a;
		throw new Eclass(" wrong format");
	}
	public static void checkdob(LocalDate a) throws Eclass{
		int aa= Period.between(a, LocalDate.now()).getYears();
		if(aa<21)
			throw new Eclass("chota hai bhai abhi ");
	}
	public static List<Customer> populatedData() {
        Customer c1 = new Customer("Pranay", "Jumde", "p@gmail.com", "123",
                2000, LocalDate.parse("1999-08-08"), Service.valueOf("GOLD"));
        Customer c2 = new Customer("Ayush", "Gupta", "a@gmail.com", "123",
                2000, LocalDate.parse("1999-08-08"), Service.valueOf("GOLD"));
        Customer c3 = new Customer("Karshin", "Sinha", "k@gmail.com", "123",
                2000, LocalDate.parse("2001-11-12"), Service.valueOf("GOLD"));
        Customer c4 = new Customer("Sai", "Kakde", "s@gmail.com", "123",
                2000, LocalDate.parse("2001-11-12"), Service.valueOf("GOLD"));
        Customer c5 = new Customer("Prajwal", "Wandhare", "pw@gmail.com", "123",
                2000, LocalDate.parse("2000-02-02"), Service.valueOf("GOLD"));

        List<Customer> customerList = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));
        /// Because of Arrays.asList() it created constant array and iterator throws exception saying Unsupported
        // So we have to create growable arraylist.

        return customerList;
    }
}
