package com.app.Validate;

import java.util.Map;
import java.util.Scanner;

import com.app.Customer.Customer;
import com.app.Exc.Eclass;

public class signin {
	public static String signinn(Map<String,Customer> a) throws Eclass{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the email");
		String e,p;
		e=sc.next();
//		for(Customer c : a) {
////			if(e.equals(c.getEmail()) && p.equals(c.getPswd())) {
////				System.out.println("successful loginnn!!!!");
////			}
//			
		Customer cust = a.get(e);
			if(e!=null){
				System.out.println("enter the pass");
				p=sc.next();
				if(cust.getPswd().equals(p)){
					System.out.println(cust.toString());
					return "successful loginnn!!s!!";
				}
				else
//					return "wrong passward";
					throw new Eclass("wrong passward");
				
				
			}
			
//		}
		sc.close();
		throw new Eclass("wrong haiiii");
		
	}
}
