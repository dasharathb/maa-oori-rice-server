package com.bas.mor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.mor.model.RespObject;
import com.bas.mor.model.UserDtl;
import com.bas.mor.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/regUser" , method=RequestMethod.GET )
	public @ResponseBody Object regUser(@RequestParam(value="userDtl") Object uDtl,HttpServletRequest request ,HttpServletResponse response){
		ObjectMapper objMapper=new ObjectMapper();
		UserDtl userDtl=null;
		UserDtl dtl=null;
		RespObject respObject = new RespObject();
		
		
		try{
			System.out.println(uDtl.toString());
			userDtl = objMapper.readValue(uDtl.toString(), UserDtl.class);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		System.out.println("User deatails*********************"+userDtl.toString());
		
		dtl = userService.getRegDtls(userDtl.getEmail());
	
		
		
		if(dtl!=null){
			respObject.setMessage("user already exist");
		}else{
			userService.saveUserDtl(userDtl);
			respObject.setMessage("user registerd seccessfully");
		}
		
		return respObject;
	}
	@RequestMapping(value="/account",method=RequestMethod.GET)
	public @ResponseBody UserDtl userDtl(@RequestParam String emailId, HttpServletRequest request,HttpServletResponse response){
		ObjectMapper objMapper= new ObjectMapper();
		
		//String emailId = objMapper.readValues(email, String.class);
		
		System.out.println("emAIl ::::::::::::::"+emailId.toString());
		UserDtl accountDtl =null;
		UserDtl dtl=null;
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		dtl=userService.getUserDtl(emailId);
		
		return dtl;
    }
	
	

}
