package com.bas.mor.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.UserDtl;
import com.bas.mor.mongo.repo.LoginRepo;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {

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
		//insert();
		LoginDtl loginDtl = loginRepo.findByUserName(userName);
		return loginDtl;
	}
	
	private void insert(){
		LoginDtl dtl = new LoginDtl();
		dtl.setFirstName("test");
		dtl.setLastName("test");
		dtl.setMessage("done");
		dtl.setPassword("test");
		dtl.setPassword("test");
		loginRepo.save(dtl);
		
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

	@Override
	public void saveUserDtl(UserDtl dtl) {
		
		mongoTemplate.save(dtl);
	}

	@Override
	public void saveLoginDtl(LoginDtl dtl) {
		
		mongoTemplate.save(dtl);
	}
}
