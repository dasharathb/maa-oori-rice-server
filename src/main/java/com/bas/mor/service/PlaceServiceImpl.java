package com.bas.mor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.mor.dao.PlaceOrderDao;
import com.bas.mor.model.PlaceOrder;

@Service(value="placeService")
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	PlaceOrderDao placeOrderDao;
	
	@Override
	public void saveOrderDtl(PlaceOrder placeDtl) {
		
		placeOrderDao.savePlaceDtl(placeDtl);
		
		 
	}

	@Override
	public List<PlaceOrder> getOrderHistory(String emailId) {
		
		return placeOrderDao.getPlaceOrderDtl(emailId);
	}

}
