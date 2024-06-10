/*Create  java  application called StockTradingService(using suitable data structure :  DS) , in a Tester.


 This application must provide following functionalities.

Stock must have these details
stock id (unique : string), stock name (string), company name(string) , price (double), closing date (Date) , quantity (int)

1. Add at least 5 sample stocks in the beginning of application in the suitable DS ,

2. Add New stock in the market
Accept all the stock details & insert it in the DS
Ensure no duplicate stock ids. Add a validation rule that stock closing date must be a future date.
In case of invalid inputs , throw custom exception & handle it in a centralized manner in StockTradingService (tester)

3. View Available stocks by Company: 
input : company name
O/P All the stocks published by that company.

4. Purchase stocks
input : stock id , quantity
In case of invalid stock id or insufficient available quantity , throw custom exception , with suitable error message.
In case of success , update stock quantity suitably.

5. Sell Stocks
input : stock id , quantity
In case of invalid stock id  throw custom exception , with suitable error message.
In case of success , update stock quantity suitably.


6. Save n Exit : Before terminating application  
save all stock details in a binary file(file name : stocks.ser) , using serialization.

Non-Functional Requirements:
1. The application must use appropriate collection(list or set / map) to save all the required information.
2. Application must throw appropriate exceptions whenever necessary.
3. Application must be created using appropriate layers.(eg : CollectionUtils ,IOUtils , Custom exception , core classes , validation rules, tester)
4. Wherever possible try to use functional programming (declarative) over imperative approach.*/
package com.app.stocks;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String stockName;
	private String companyName;
	private Double price;
	private LocalDate date;
	private int quantity;
	
	
	
	
	public Stock(String id ,String stockName, String companyName, Double price, LocalDate date, Integer quantity) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.date = date;
		this.quantity = quantity;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(companyName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Stock))
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(companyName, other.companyName);
	}


	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockName=" + stockName + ", companyName=" + companyName + ", price=" + price
				+ ", date=" + date + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
