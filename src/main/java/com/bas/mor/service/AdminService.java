package com.bas.mor.service;

import java.util.List;

import com.bas.mor.model.PlaceOrder;

public interface AdminService {
	public List<PlaceOrder> getOrderDtlForAdmin();

	public void status(String ordId, String status);


}
