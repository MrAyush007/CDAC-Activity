package com.app.Tester;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.app.Contact.Contact;
import com.app.ValidateClass.Validate;
import com.app.utils.Utillity;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			Set<Contact> contactList = new HashSet<>();
			do {
				System.out.println("------------Welcome to Phone Book Application-------");
				System.out.println();
				System.out.println("------------Choose the option given below-------");
				System.out.println("1.ADD NUMBER \n2.DISPLAY");
				try {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter the details \nNUMBER   NAME   DOB   E-MAIL");
					Contact tempContact =Utillity.addNumber(sc.next(), sc.next(), sc.next(), sc.next());
					Validate.addException(contactList.add(tempContact));
					System.out.println("Added successfully");
					break;
				case 2 :
					System.out.println("---------ALL Contact---------------");
					Iterator<Contact> itr = contactList.iterator();
					while(itr.hasNext()){
						System.out.println(itr.next());
					}
					break;

				default:
					break;
				}
			}catch (Exception e) {
				System.out.println(e.toString());
				sc.nextLine();
			}
			}while(true);	
				
				
				
				
				
				
				
			}
			
		}

	}


