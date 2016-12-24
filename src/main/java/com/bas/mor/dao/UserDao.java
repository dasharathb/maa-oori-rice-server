package com.bas.mor.dao;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.UserDtl;

public interface UserDao {

	public LoginDtl getLoginDtl(LoginDtl loginDtl);

	public void saveUserDtl(UserDtl dtl);

	public void saveLoginDtl(LoginDtl dtl);

	public UserDtl getUserDetails(LoginDtl loginDtl);

	public UserDtl getUserDtl(String email);

	public PlaceOrder getPlaceDtl(PlaceOrder placeDtl);


}
