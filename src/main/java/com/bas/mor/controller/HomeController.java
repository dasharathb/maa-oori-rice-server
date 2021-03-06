package com.bas.mor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.Person;
import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.RespObject;
import com.bas.mor.model.UserDtl;
import com.bas.mor.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public @ResponseBody List<Person> homepage(HttpServletRequest req, HttpServletResponse response){
		System.out.println("this is home controller..................");
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
	        
		
		List<Person> list = new ArrayList<Person>();
		
		Person person = new Person("Dasharath","Bhukya");
		Person person1 = new Person("Ramesh","Guguloth");
		Person person2 = new Person("Dasharath","Bhukya");
		Person person3 = new Person("Sumalath","Eslavath");
		Person person4 = new Person("Rajesh","abc");
		
		list.add(person);
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		System.out.println("this is home controller..................");
		return list;
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public @ResponseBody Object login(@RequestParam(value="loginDtl") Object login, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		LoginDtl loginDtl = null;
		LoginDtl dtl = null;
		UserDtl userDtl = null;
		try {
			loginDtl = objMapper.readValue(login.toString(), LoginDtl.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("loginDtl ::::::::::::::: "+loginDtl.toString());
		
		dtl = userService.getLoginDtls(loginDtl);
		if(dtl == null){
			return userDtl;
		}else if(!dtl.getPassword().equals(loginDtl.getPassword())){
			return userDtl;
		}
		
		userDtl = userService.getUserDetails(loginDtl);
		System.out.println("userDtl ::::::"+userDtl.toString());
		return userDtl;
	}
	
	
}
