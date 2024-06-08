package com.app.validate;

import java.util.Map;

import com.app.Exeception.Authenticat1ionException;
import com.app.Exeception.OutOfStock;
import com.app.entity.pet;

public class validatePet {

	public static pet validatePetId (int id, Map<Integer, pet> map)throws Authenticat1ionException{
		pet p2 = map.get(id);
		if(p2!=null){
			return p2;
		}
		System.out.println(p2);
		throw new Authenticat1ionException("invalid pet ID");
	}
	public static boolean validatequantity (int id,int quantity, Map<Integer, pet> map)throws OutOfStock{
		pet p2 = map.get(id);
		if(p2!=null){
			if(p2.getStock()-quantity>=0){
				p2.setStock(p2.getStock()-quantity);
				return true;
			}
		}
		throw new OutOfStock("pet is out of stock");
	}
}
