package com.bas.mor.model;

public class PlaceOrder {
	private String riceType;
	private String quantity;
	
	public PlaceOrder() {
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
		return "PlaceOrder [riceType=" + riceType + ", quantity=" + quantity + "]";
	}

	
   }

