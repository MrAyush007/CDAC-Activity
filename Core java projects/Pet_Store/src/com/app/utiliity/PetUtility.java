package com.app.utiliity;

import java.util.Map;


import com.app.entity.Category;
import com.app.entity.pet;
//petId, name, category, unitPrice, stocks
public class PetUtility {
	
	public static String addPet( String name, Category category , int unitPrice , int stock, Map<Integer, pet>map) {
		pet p1 = new pet(name, category, unitPrice, stock);
		map.put(p1.getPetId(),p1);
		return "successfully Added";
	}
	public static void displayPet(Map<Integer, pet> map) {
		map.forEach((k,v)->System.out.println(v));
	}
}
