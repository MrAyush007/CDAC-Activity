package com.app.utility;

import static com.app.validate.StockValidate.validateDate;
import static com.app.validate.StockValidate.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.stockException.InvalidInput;
import com.app.stockException.OutOfStock;
import com.app.stocks.Stock;

public class stockUtility {
	public static String addStock(String id ,String stockName, String companyName, Double price, String date, int quantity,Map<String,Stock> map) throws InvalidInput
	{
		validateId(id,map);
		LocalDate newDate = validateDate(date);
		Stock s1 = new Stock(id, stockName, companyName, price, newDate, quantity);
		map.put(id, s1);
		return "successfully Added";
	}
	public static void displayStock(Map<String, Stock> map) 
	{
		map.values().forEach(s->System.out.println(s));
	}
	public static void displayByCompanyName(String companyName,Map<String, Stock> map) throws InvalidInput
	{
//		for single result
//		 Stock o1 = map.values().stream().filter(s->s.getCompanyName().equals(companyName)).findAny().orElse(null);
//		 System.out.println(o1);
//		 for multiple result
		 List<Stock> filteredValues = map.entrySet().stream()
				    .filter(s->s.getValue().getCompanyName().equals(companyName))
				    .map(Map.Entry::getValue)
				    .collect(Collectors.toList());
		 filteredValues.forEach(s->System.out.println(s));
		
//		 normal method to all stock
//		for ( Stock s : map.values()) {
//				if(s.getCompanyName().equals(companyName)) {
//					System.out.println(s);
//				}
//		}
	}
	public static void purchaseStock(String id , int quantity , Map<String,Stock> map) throws InvalidInput, OutOfStock 
	{
		Stock s1 = validateQuantity(id,quantity,map);
		System.out.println(s1);
	}
	public static void sellStock(String id , int quantity , Map<String,Stock> map) throws InvalidInput, OutOfStock 
	{
		Stock s1 = validateQuantityForSell(id,quantity,map);
		System.out.println(s1);
	}
	public static void sortByPrice(Map<String, Stock> map ) 
	{
//		map.entrySet().stream()
//		.sorted(Map.entry(, null))
		
		List<Stock> list = new ArrayList<>(map.values());
		Collections.sort(list,new Comparator<Stock>() {

			@Override
			public int compare(Stock o1, Stock o2) {
				return o1.getPrice().compareTo(o2.getPrice());

			}
		});
		
//		map = map.entrySet().stream()
//        .sorted(Map.Entry.<String, Stock>comparingByValue(Comparator.comparingInt(Stock::getPrice)))
//        .collect(Collectors.toMap(
//            Map.Entry::getKey,
//            Map.Entry::getValue,
//            (e1, e2) -> e1,
//            LinkedHashMap::new
//        ));
	}
	public static void maxPrice(Map<String, Stock> map) 
	{
//		Double maxx = map.values().stream().mapToDouble(Stock :: getPrice).max().orElse(0.0);
		Double sum = map.values().stream().mapToDouble(Stock :: getPrice).sum();

//		System.out.println(maxx);
		System.out.println(sum);
	}
}
