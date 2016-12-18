package com.bas.mor.dao;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.UserDtl;

public interface UserDao {

	public LoginDtl getLoginDtl(String userName);

	public void saveUserDtl(UserDtl dtl);

	public void saveLoginDtl(LoginDtl dtl);

}
