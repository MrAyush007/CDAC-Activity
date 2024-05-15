package com.app.Validate;

import java.util.List;
import java.util.Scanner;

import com.app.Customer.Customer;
import com.app.Exc.Eclass;

public class passward {
	public static void changee(List<Customer> a) throws Eclass{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the email");
		String e,p,np;
		e=sc.next();
		Customer c = new Customer(e);
		
		int check =a.indexOf(c);
		if(check!=-1) {
			System.out.println("enter the old_Passward");
			p=sc.next();
			if(a.get(check).getPswd().equals(p)) {
				System.out.println("enter the NEW_Passward");
				np=sc.next();
				c.setPswd(np);
				System.out.println("passward change!!!!");
			}
			else
				throw new Eclass("wrong passward");
			
		}
		else
			throw new Eclass("wrong e-mail haiiii");
		
//		for(Customer c : a) {
////			if(e.equals(c.getEmail()) && p.equals(c.getPswd())) {
////				System.out.println("successful loginnn!!!!");
////			}
//			
//			if(e.equals(c.getEmail())){
//				System.out.println("enter the old_Passward");
//				p=sc.next();
//				if(p.equals(c.getPswd())){
//					System.out.println("enter the NEW_Passward");
//					np=sc.next();					
//					c.setPswd(np);
//					return "done";
//				}
//				else
////					return "Wrong passward";
//					throw new Eclass("wrong passward"); 
//				
//			}
//			
//		}
//		sc.close();
//		throw new Eclass("wrong e-mail haiiii");	
	}
}
