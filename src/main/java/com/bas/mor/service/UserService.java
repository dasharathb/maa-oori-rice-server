package com.bas.mor.service;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.UserDtl;

public interface UserService {

	public LoginDtl getLoginDtls(LoginDtl dtl);
	public UserDtl saveUserDtl(UserDtl dtl);
	public UserDtl getUserDetails(LoginDtl loginDtl);
	public UserDtl getUserDtl(String email);
	public PlaceOrder getPlaceDtls(PlaceOrder placeDtl);
	

}
