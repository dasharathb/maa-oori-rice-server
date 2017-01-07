package com.bas.mor.service;

import java.util.List;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.UserDtl;

public interface UserService {

	public LoginDtl getLoginDtls(LoginDtl dtl);
	public void saveUserDtl(UserDtl dtl);
	public UserDtl getUserDetails(LoginDtl loginDtl);
	public UserDtl getUserDtl(String email);
	public UserDtl getRegDtls(String email);
	
	
	

}
