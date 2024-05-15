package com.app.Client;

import static com.app.Validate.ValidateClass.customervalidateinput;
import static IOutils.ReadData.readdata;
import static IOutils.WriteData.writedata;
import static com.app.Validate.ValidateClass.populatedData;
//import static com.app.Validate.Vclass.vaildplann;
import static com.app.Validate.del.delete;
import static com.app.Validate.passward.changee;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributeIdentifierException;

import com.app.Customer.Customer;
import com.app.Validate.signin;

import IOutils.WriteData;

public class Client1 {

	public static void main(String[] args) {
		
		Map<String,Customer> customes = populatedData();
		String ss=null;
		
		try(Scanner sc =new Scanner(System.in)) {
//		System.out.println("Enter number of employee");
//		int count=0;
//		Customer[] cc =new Customer [sc.nextInt()];
		while(true) {
			try {
			
			System.out.println("enter choice");
			System.out.println(" 1.Sign up \n 2. Sign in \n 3. Change password \n 4. Un subscribe customer \n 5. Display all customers. \n 6. to Save all data \n 7.to Read data 0. Exit \n");
			switch (sc.nextInt()) {
			case 1:
				 System.out.println("ENTER ALL DETAILS");
				 System.out.println("Enter fname, lname, email, password, registration_amt, dob, sname ");
				 Customer cust= customervalidateinput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customes);
				 customes.put(cust.getEmail(), cust);
				 System.out.println("Added successfully");
				break;
			case 2:
				String o = signin.signinn(customes);
				System.out.println(o);
				break;
			case 3:
				changee(customes); 
				break;
			case 4:
				System.out.println(delete(customes)); 
				break;
				
			case 5:
				for(Customer c : customes.values()) {
					System.out.println(c);
				}
				break;
			case 6:{
				System.out.println("enter the file name u wanna copy data");
				ss=sc.next();
				writedata(customes,ss);
				break;
			}
			case 7:{
				System.out.println("enter the file name u wanna read data");
				ss=sc.next();
				readdata(ss).values().stream().forEach(k->System.out.println(k));
				return ;
				
			}
			case 0:
				System.out.println("exited!!");
				return ;
			default:
				break;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
			
		}
		
	}
		
	}

}
