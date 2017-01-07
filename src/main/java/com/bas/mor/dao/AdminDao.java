package com.bas.mor.dao;

import java.util.List;

import com.bas.mor.model.PlaceOrder;

public interface AdminDao {
	public List<PlaceOrder> getOrderDtlForAdmin();

	public void saveStatus(String ordId, String status);

}
