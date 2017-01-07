package com.bas.mor.dao;

import java.util.List;

import com.bas.mor.model.PlaceOrder;

public interface PlaceOrderDao {
	
	public void savePlaceDtl(PlaceOrder placeDtl);


	public List<PlaceOrder> getPlaceOrderDtl(String emailId);

}
