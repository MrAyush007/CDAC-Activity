package com.app.entity;

public class Order {
//	Order (orderId, petId, quantity, status)
	private static int idGenerator;
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	public static int getIdGenerator() {
		return idGenerator;
	}
	public static void setIdGenerator(int idGenerator) {
		Order.idGenerator = idGenerator;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Order(int petId, int quantity) {
		super();
		this.orderId=++idGenerator;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
	
	
	
	
}
