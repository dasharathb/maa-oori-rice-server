package com.bas.mor.service;

import java.util.List;

import com.bas.mor.model.PlaceOrder;

public interface PlaceService {
	public void    saveOrderDtl(PlaceOrder placeDtl);
	public List<PlaceOrder> getOrderHistory(String emailId);

}
