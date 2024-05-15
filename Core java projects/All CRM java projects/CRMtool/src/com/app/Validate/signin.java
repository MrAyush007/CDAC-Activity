package com.app.Validate;

import java.util.List;
import java.util.Scanner;

import com.app.Customer.Customer;
import com.app.Exc.Eclass;

public class signin {
	public static String signinn(List<Customer> a) throws Eclass{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the email");
		String e,p;
		e=sc.next();
		for(Customer c : a) {
//			if(e.equals(c.getEmail()) && p.equals(c.getPswd())) {
//				System.out.println("successful loginnn!!!!");
//			}
			
			if(e.equals(c.getEmail())){
				System.out.println("enter the pass");
				p=sc.next();
				if(p.equals(c.getPswd())){
					System.out.println(c.toString());
					return "successful loginnn!!s!!";
				}
				else
//					return "wrong passward";
					throw new Eclass("wrong passward");
				
				
			}
			
		}
		sc.close();
		throw new Eclass("wrong haiiii");
		
	}
}
