package com.app.tester;


import static com.app.utiliity.PetUtility.addPet;

import static com.app.utiliity.PetUtility.displayPet;
import static com.app.utiliity.UserUtility.displayUser;
import static com.app.utiliity.UserUtility.loginUser;
import static com.app.utiliity.UserUtility.populatedData;
import static com.app.validate.validatePet.*;
import static com.app.utiliity.orderUtility.*;
import static com.app.validate.orderValidate.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.Exeception.AuthorizationException;
import com.app.entity.Category;
import com.app.entity.Order;
import com.app.entity.User;
import com.app.entity.pet;


public class Client {
	public static void main(String[] args) {
		Map<String, User> map = new HashMap<>();
		map=populatedData();
		Map<Integer, pet> petMap = new HashMap<>();
		Map<Integer, Order> orderMap = new HashMap<>();
		
		
		try(Scanner sc = new Scanner(System.in))
		{
			
			System.out.println("e-mail & pass");
			User u1 = loginUser(sc.next(), sc.next(), map);
			
			while(true) {
			try{
				System.out.println("Enter the choice");
				System.out.println(" 1.Display \n 2.Add Pet \n 3.Update pet \n 4.Display Pet \n 5.order a pet \n 6.check order status"
						+ "\n 7.update order status");
				switch (sc.nextInt()) {
				case 1:
					displayUser(map);
					break;
				case 2:{
					if(u1.isAdmin()){
					System.out.println("name, category, unitPrice, stocks");	
					System.out.println(addPet(sc.next(),Category.valueOf(sc.next().toUpperCase()),sc.nextInt(),sc.nextInt(),petMap));
					petMap.forEach((k,v)->System.out.println(v));
					break;
					}
					else {
						throw new AuthorizationException("User not allowed to access this option");
					}
				}
				case 3:
					if(u1.isAdmin()) {
						System.out.println("enter the petId");
//						System.out.println(petMap.containsKey(sc.nextInt()));
						pet p2 = validatePetId(sc.nextInt(), petMap);
						if(p2!=null) {
							System.out.println("name, category, unitPrice, stocks");
							p2.setName(sc.next());
							p2.setCategory(Category.valueOf(sc.next().toUpperCase()));
							p2.setUnitPrice(sc.nextInt());
							p2.setStock(sc.nextInt());
							break;
						}	
					}else
					{
						throw new AuthorizationException("User not allowed to access this option");
					}
				case 4:
					
					displayPet(petMap);
					break;
		
				case 5:
					 
					System.out.println("Enter petId , quantity");
					System.out.println(addOrder(sc.nextInt(),sc.nextInt(), orderMap, petMap));
					orderMap.forEach((k,v)->System.out.println(v));
					break;
					
				case 6:
					
					System.out.println("Enter order ID");
					checkOrderStatus(sc.nextInt(),orderMap);
					break;
					
				case 7:
					if(u1.isAdmin()){ 
					System.out.println("Enter order ID & Status");
					updateOrderStatus(sc.nextInt(), sc.next(),orderMap);
					break;
					}
				default:
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
	}
}
}