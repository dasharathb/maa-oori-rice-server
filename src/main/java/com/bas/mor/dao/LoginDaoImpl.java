package com.bas.mor.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.mongo.repo.LoginRepo;
import com.bas.mor.util.Constants;

@Component(value="loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public LoginDtl getLoginDtl(String userName){
		
		/*Aggregation aggregations = newAggregation(
				match(Criteria.where("userId").is(userId))
				);
		LoginDtl result = getQueryAggrgationResults(aggregations,Constants.LOGIN_DLT);
*/
		LoginDtl loginDtl = loginRepo.findByUserName(userName);
		return loginDtl;
	}
	
	private LoginDtl getQueryAggrgationResults(Aggregation aggregations,String collectionNameToFetchRecords) {
		//Convert the aggregation result into a List
		LoginDtl result = new LoginDtl();
		try{
			AggregationResults<LoginDtl> groupResults 
			= mongoTemplate.aggregate(aggregations, collectionNameToFetchRecords, LoginDtl.class);
			result = groupResults.getUniqueMappedResult();
		}catch(Exception e){
			//throw new AggregationException(e.getMessage());
		}
		return result;
	}
}
