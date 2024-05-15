package com.app.Validate;

import java.util.Map;
import java.util.Scanner;

import com.app.Customer.Customer;
import com.app.Exc.Eclass;

public class del {
	public static Customer delete(Map<String,Customer> a) throws Eclass {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the e-mail");
		String aa= sc.next();
		Customer cust = a.remove(aa);
		if(cust!=null){
			System.out.println("Deleted");
			return cust;
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
