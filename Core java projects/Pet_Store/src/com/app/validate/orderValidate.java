package com.app.validate;

import java.util.Map;

import com.app.Exeception.Authenticat1ionException;
import com.app.Exeception.InvalidStatus;
import com.app.entity.Order;
import com.app.entity.Status;

public class orderValidate {
	public static void checkOrderStatus(int orderId,Map<Integer, Order> map) throws Authenticat1ionException
	{
		Order o1 = map.get(orderId);
		if(o1!=null){
			System.out.println(o1.getStatus());
			return ;
		}
		throw new Authenticat1ionException("invalid order ID!!!!");
	}
	public static void validateStatus(String status) throws InvalidStatus
	{
		for(Status s : Status.values()) {
			if(s==Status.valueOf(status))
			{
				return ;
			}
		}
		throw new InvalidStatus("invalid Status");
	}
	
}
