package com.app.tester;

import static com.app.utility.Ioutils.writeDetails;

import static com.app.utility.stockUtility.addStock;
import static com.app.utility.stockUtility.displayByCompanyName;
import static com.app.utility.stockUtility.displayStock;
import static com.app.utility.stockUtility.purchaseStock;
import static com.app.utility.stockUtility.sellStock;
import static com.app.utility.stockUtility.sortByPrice;
import static com.app.utility.stockUtility.maxPrice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.stocks.Stock;
import com.app.utility.Ioutils;

public class client implements Ioutils{
	public static void main(String[] args) {
		Map<String, Stock> map = new HashMap<>();

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.println("enter the choice");
					System.out.println(" 1. add stock \n 2.Display \n 3. All stock by company \n 4.purchase Stock \n 5.sell Stocks\n 6. print All data ");
					switch (sc.nextInt()) {
					case 1:
//						try {
//							System.out.println("enter 5 stock(min)");
//							boolean flag = false;
//							while (map.size() < 6) {
								
//					stock id  stock name company name , price  closing date  quantity
								System.out.println("enter the datails");
								System.out.println("id,stock_name,company_name,price ,closing_date,quantity");
								addStock(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.nextInt(),
										map);
//							}
//
//						} catch (Exception e) {
//							e.printStackTrace();
//							while (!map.isEmpty()) {
//								map.remove(map.size());
//							}
//
//						}
						break;
					case 2:
						displayStock(map);
						break;

					case 3:
						System.out.println("enter the conpany names to see all stock of that company");
						displayByCompanyName(sc.next(), map);
						break;
					case 4:
						System.out.println("enter the stockId,quantity");
						purchaseStock(sc.next(), sc.nextInt(), map);
						break;
					case 5:
						System.out.println("enter the stockId,quantity");
						sellStock(sc.next(), sc.nextInt(), map);
						break;
					case 6:
						System.out.println("enter the FileName");
						writeDetails(sc.next(),map);
						System.out.println("successfully printed");
						break;
					case 7:
						System.out.println("sort by date");
						sortByPrice(map);
						break;
					case 8:
						System.out.println("sort by date");
						maxPrice(map);
						break;
					

					default:
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}
}
