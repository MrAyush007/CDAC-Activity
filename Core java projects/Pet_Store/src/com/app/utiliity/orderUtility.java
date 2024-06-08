package com.app.utiliity;

import static com.app.validate.validatePet.*;

import java.util.Map;

import com.app.Exeception.Authenticat1ionException;
import com.app.Exeception.OutOfStock;
import com.app.entity.Order;
import com.app.entity.Status;
import com.app.entity.pet;

public class orderUtility {
//	Order (orderId, petId, quantity, status)
	
	public static String addOrder(int petId,int quantity,Map<Integer, Order> map,Map<Integer, pet> petmap) throws Authenticat1ionException,OutOfStock
	{
		validatePetId(petId,petmap);
		validatequantity(petId, quantity, petmap);
		Order o1 = new Order(petId, quantity);
		map.put(o1.getOrderId(), o1);
		return "successfully Added!!!!";
		
	}
	public static Order updateOrderStatus(int orderId , String status , Map<Integer, Order> map) throws Authenticat1ionException
	{
		Order o1 = map.get(orderId);
		if(o1!=null){
			o1.setStatus(Status.valueOf(status.toUpperCase()));
			return o1;
		}
		throw new Authenticat1ionException("invalid order ID!!!!");
	}
	
}
