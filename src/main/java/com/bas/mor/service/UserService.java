package com.bas.mor.service;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.UserDtl;

public interface UserService {

	public LoginDtl getLoginDtls(LoginDtl dtl);
	public UserDtl saveUserDtl(UserDtl dtl);
	

}
