package com.app.Plan;

public enum Service {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLAT(10000);
	private double price; 
	private Service(double price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return name() + " " + price;
	}

}
