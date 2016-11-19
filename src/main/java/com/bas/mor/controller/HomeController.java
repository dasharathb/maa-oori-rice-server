package com.bas.mor.controller;

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
import com.bas.mor.service.LoginService;

@Controller
public class HomeController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public @ResponseBody List<Person> homepage(HttpServletRequest req, HttpServletResponse response){
		System.out.println("this is home controller..................");
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		//response.addHeader("Access-Control-Allow-Origin", "*");
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
	public @ResponseBody LoginDtl login(@RequestParam String userName, @RequestParam String password,  HttpServletRequest req, HttpServletResponse response){
		System.out.println("this is login method....1 ..............");
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		LoginDtl loginDtl = new LoginDtl();
		loginDtl.setUserName(userName);
		loginDtl.setPassword(password);
		
		System.out.println("loginDtl :::::::::::::::: "+loginDtl);
		
		LoginDtl dtl = loginService.getLoginDtls(loginDtl);
		if(dtl != null && !loginDtl.getPassword().equals(dtl.getPassword())){
			loginDtl.setMessage("password incorrect...");
			return loginDtl;
		}else{
			dtl.setPassword("");
			return dtl;
		}
	}
}
