package com.app.validate;

import java.time.LocalDate;
import java.util.Map;

import com.app.stockException.InvalidInput;
import com.app.stockException.OutOfStock;
import com.app.stocks.Stock;

public class StockValidate {
	public static LocalDate validateDate(String date) throws InvalidInput


	{
		LocalDate d1 = LocalDate.parse(date);
		if(d1.isAfter(LocalDate.now())) 
		{
			throw new InvalidInput("Date is Invalid");
		}
		return d1;
	}
	public static void validateId(String id , Map<String,Stock> map) throws InvalidInput
	{
		if(map.containsKey(id)) 
		{
			throw new InvalidInput("Stock Already Existed");
		}
	}
	public static Stock validateQuantity(String id,int quantity, Map<String, Stock> map) throws OutOfStock,InvalidInput
	{
		Stock s1 = map.entrySet().stream()
	            .filter(entry -> entry.getValue().getId().equals(id))
	            .filter(entry -> entry.getValue().getQuantity() > quantity)
	            .map(entry -> {
	                Stock stock = entry.getValue();
	                stock.setQuantity((stock.getQuantity())-quantity);
	                return stock;
	            })
	            .findFirst().orElse(null);
		if(s1==null) {
			throw new OutOfStock("insufficient available quantity");
		}
		return s1;
	}
	//custom exception but some error
//	public static Stock validateQuantity(String id, int quantity, Map<String, Stock> map) throws  InvalidInput, OutOfStock {
//        Stock s1 = map.entrySet().stream()
//            .filter(entry -> {
//                if (!entry.getValue().getId().equals(id))  {
//                    throw new InvalidInput("Invalid Input: ID " + id + " not found");
//                }
//                return true;
//            })
//            .filter(entry -> entry.getValue().getQuantity() > quantity)
//            .map(entry -> {
//                Stock stock = entry.getValue();
//                stock.setQuantity(stock.getQuantity() - quantity);
//                return stock;
//            })
//            .findFirst().orElse(null);
//
//        if (s1 == null) {
//            throw new OutOfStock("Insufficient available quantity for ID " + id);
//        }
//        return s1;
//    }
	
	
	
	public static Stock validateQuantityForSell(String id,int quantity, Map<String, Stock> map) throws OutOfStock,InvalidInput
	{
		Stock s1 = map.entrySet().stream()
				.filter(s->s.getValue().getId().equals(id))
				.map(s->{
					Stock ss = s.getValue();
					ss.setQuantity(ss.getQuantity()+quantity);
					return ss;
				}).findFirst().orElse(null);
		if(s1==null) {
			throw new InvalidInput("InvalidInput");
		}
		return s1;
	}
	
}
