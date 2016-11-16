package com.bas.mor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.mor.dao.LoginDao;
import com.bas.mor.model.LoginDtl;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public LoginDtl getLoginDtls(LoginDtl dtl){
		
		LoginDtl loginDtl = loginDao.getLoginDtl(dtl.getUserName());
		
		if(loginDtl != null){
			return loginDtl;
		}
		
		return null;
	}

}
