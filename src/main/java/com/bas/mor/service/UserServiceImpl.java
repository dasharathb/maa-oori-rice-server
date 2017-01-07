package com.bas.mor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.mor.dao.UserDao;
import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.UserDtl;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	
	@Override
	public LoginDtl getLoginDtls(LoginDtl dtl){
		
		LoginDtl loginDtl = userDao.getLoginDtl(dtl);
		
		if(loginDtl != null){
			return loginDtl;
		}
		
		return null;
	}

	@Override
	public void saveUserDtl(UserDtl dtl) {
		
		LoginDtl loginDtl = setLoginData(dtl);
		userDao.saveLoginDtl(loginDtl);
		
		dtl.setPassword(null);
		userDao.saveUserDtl(dtl);

	}
	
	private LoginDtl setLoginData(UserDtl dtl){
		LoginDtl loginDtl = new LoginDtl();
		loginDtl.setFirstName(dtl.getFirstName());
		loginDtl.setLastName(dtl.getLastName());
		loginDtl.setEmail(dtl.getEmail());
		loginDtl.setPhone(dtl.getPhone());
		loginDtl.setPassword(dtl.getPassword());
		return loginDtl;
	}

	@Override
	public UserDtl getUserDetails(LoginDtl loginDtl) {
		return userDao.getUserDetails(loginDtl);
	}
	
	public UserDtl getUserDtl(String email){

		return userDao.getUserDtl(email);
	}

	
	
	@Override
	public UserDtl getRegDtls(String emailId) {
	
		return userDao.getRegDtls(emailId);
	}

	


	

}
