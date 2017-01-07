package com.bas.mor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.mor.dao.AdminDao;
import com.bas.mor.model.PlaceOrder;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public List<PlaceOrder> getOrderDtlForAdmin() {		
		return adminDao.getOrderDtlForAdmin();
	}

	@Override
	public void status(String ordId, String status) {
		adminDao.saveStatus(ordId, status);
		
	}


}
