package com.bas.mor.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.RespObject;
import com.bas.mor.model.UserDtl;
import com.bas.mor.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminOrderController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/admin/orders",method=RequestMethod.GET)
	public @ResponseBody List<PlaceOrder> placeOrder(HttpServletRequest request,HttpServletResponse response){
		List<PlaceOrder> dtl=null;		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		dtl=adminService.getOrderDtlForAdmin();
		return dtl;
    }
	
	
	@RequestMapping(value="/adminStatus",method=RequestMethod.GET)
	public @ResponseBody String status(@RequestParam(value="orderId") String orderId, @RequestParam(value="status") String status,HttpServletRequest request,HttpServletResponse response){
				
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		adminService.status(orderId, status);
		return "{'status:'updated'}";
    }
}

