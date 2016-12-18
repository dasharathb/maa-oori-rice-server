package com.bas.mor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.mor.dao.UserDao;
import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.UserDtl;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	
	@Override
	public LoginDtl getLoginDtls(LoginDtl dtl){
		
		LoginDtl userDtl = userDao.getLoginDtl(dtl.getFirstName());
		
		if(userDtl != null){
			return userDtl;
		}
		
		return null;
	}

	@Override
	public UserDtl saveUserDtl(UserDtl dtl) {
		
		LoginDtl loginDtl = setLoginData(dtl);
		userDao.saveLoginDtl(loginDtl);
		userDao.saveUserDtl(dtl);
		return null;
	}
	
	private LoginDtl setLoginData(UserDtl dtl){
		LoginDtl loginDtl = new LoginDtl();
		loginDtl.setFirstName(dtl.getFirstName());
		loginDtl.setLastName(dtl.getLastName());
		loginDtl.setPassword(dtl.getPassword());
		return loginDtl;
	}


	

}
