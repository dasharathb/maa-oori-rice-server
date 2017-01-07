package com.bas.mor.controller;

import java.io.IOException;

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
import com.bas.mor.model.UserDtl;
import com.bas.mor.service.PlaceService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class PlaceOrderController {
	@Autowired
	PlaceService placeService;
	
	@RequestMapping(value="/placeorder", method=RequestMethod.GET)
	public @ResponseBody void placeOrder(@RequestParam(value="placeorder")Object pOrd, HttpServletRequest request,HttpServletResponse response){
			
		
		//String emailId = objMapper.readValues(email, String.class);

				ObjectMapper objMapper = new ObjectMapper();
				PlaceOrder placeDtl = null;
				PlaceOrder dtl = null;
				UserDtl userDtl = null;
				System.out.println(pOrd.toString());
				try {
					placeDtl = objMapper.readValue(pOrd.toString(),PlaceOrder.class);
					
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
				response.addHeader("Access-Control-Allow-Origin", "*");
				response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
				
				System.out.println("placedtl ::::::::::::::: "+placeDtl.toString());
				placeService.saveOrderDtl(placeDtl);
				
  }
	@RequestMapping(value="/orderHistory",method=RequestMethod.GET)
	public @ResponseBody List<PlaceOrder> placeOrder(@RequestParam String emailId, HttpServletRequest request,HttpServletResponse response){
		
		//String emailId = objMapper.readValues(email, String.class);
		
		System.out.println("emAIl ::::::::::::::"+emailId.toString());
		List<PlaceOrder> dtl=null;
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		dtl=placeService.getOrderHistory(emailId);
		return dtl;
    }
	
	

}
