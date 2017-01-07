package com.bas.mor.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order_dtl")
public class PlaceOrder {
	private String id;
	private String check;
	private String email;
	private String phone;
	private List<OrderList> orderList;
	private String status;
    private String date;	
	
	public PlaceOrder() {
		super();
	}

	public PlaceOrder(String id, String check, String email, String phone, List<OrderList> orderList, String status,
			String date) {
		super();
		this.id = id;
		this.check = check;
		this.email = email;
		this.phone = phone;
		this.orderList = orderList;
		this.status = status;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<OrderList> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderList> orderList) {
		this.orderList = orderList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PlaceOrder [id=" + id + ", check=" + check + ", email=" + email + ", phone=" + phone + ", orderList="
				+ orderList + ", status=" + status + ", date=" + date + "]";
	}
	
   }

