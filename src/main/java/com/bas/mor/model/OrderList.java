package com.bas.mor.model;

public class OrderList {
	private String riceType;
	private String quantity;
	
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRiceType() {
		return riceType;
	}
	public void setRiceType(String riceType) {
		this.riceType = riceType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderList [riceType=" + riceType + ", quantity=" + quantity + "]";
	}
	
}
