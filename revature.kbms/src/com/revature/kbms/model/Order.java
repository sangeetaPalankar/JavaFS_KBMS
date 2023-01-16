package com.revature.kbms.model;

public class Order {
	private int orderId;
	private String productName;
	private int quantity;
	private double totalPrice;
	private String status;
//	private int productId;
//	private String userId;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, String productName, int quantity, double totalPrice, String status) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", status=" + status + "]";
	}
	

}
