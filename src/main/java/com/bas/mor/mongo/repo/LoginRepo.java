package com.bas.mor.mongo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bas.mor.model.LoginDtl;

public interface LoginRepo extends PagingAndSortingRepository<LoginDtl, String> {
	//public LoginDtl findByUserName(String userName);
}
