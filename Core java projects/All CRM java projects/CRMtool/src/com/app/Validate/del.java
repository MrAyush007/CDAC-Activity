package com.app.Validate;

import java.util.List;
import java.util.Scanner;

import com.app.Customer.Customer;
import com.app.Exc.Eclass;

public class del {
	public static Customer delete(List<Customer> a) throws Eclass {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the e-mail");
		String aa= sc.next();
		Customer b = new Customer(aa);
		Customer g = a.remove(a.indexOf(b));
		if(g!=null){
			System.out.println("Deleted");
			return g;
		}
		throw new Eclass("e-mail not existed");
		
//		for(Customer c : a) {
//			if(aa.equals(c.getEmail())) {
//				c.setnull();
//				System.out.println("deleted!!!!");
//				return ;
//			}
//		}
		
	}
}
