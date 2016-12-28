package com.bas.mor.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.bas.mor.model.LoginDtl;
import com.bas.mor.model.PlaceOrder;
import com.bas.mor.model.UserDtl;
import com.bas.mor.mongo.repo.LoginRepo;
import com.bas.mor.util.Constants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	LoginRepo loginRepo;

	@Override
	public LoginDtl getLoginDtl(LoginDtl dtl){
		
		LoginDtl loginDtl = null;
		/*DBObject dbObj = null;
		DBCollection collection = mongoTemplate.getCollection(Constants.LOGIN_DLT);*/
		String queryObject = "";
		if(dtl.getEmail() != null && dtl.getEmail()!=""){
			queryObject = "{'email' : '"+dtl.getEmail()+"'}";
		}
		if(dtl.getPhone() != null){
			queryObject = "{'phone' : '"+dtl.getPhone()+"'}";
		}

		BasicQuery query= new BasicQuery(queryObject);
		loginDtl = mongoTemplate.findOne(query, LoginDtl.class);
		/*if(dbCursor.hasNext()){
			dbObj = dbCursor.next();
			loginDtl = (LoginDtl) dbObj;
			
		}*/

		//insert();
		//LoginDtl loginDtl = loginRepo.findByUserName(userName);
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

	@Override
	public void saveUserDtl(UserDtl dtl) {

		mongoTemplate.save(dtl);
	}
	
	@Override
	public void savePlaceDtl(PlaceOrder dtl) {

		mongoTemplate.save(dtl);
	}

	@Override
	public void saveLoginDtl(LoginDtl dtl) {

		mongoTemplate.save(dtl);
	}

	@Override
	public UserDtl getUserDetails(LoginDtl loginDtl) {
		UserDtl userdtl=null;
		String queryObject="";
		/*DBCollection collection=mongoTemplate.getCollection(Constants.USER_DLT);*/
		if(loginDtl.getEmail()!=null && loginDtl.getEmail()!=""){
			queryObject = "{'email' : '"+loginDtl.getEmail()+"'}";
		}
		if(loginDtl.getPhone()!=null){
			queryObject = "{'phone': '"+loginDtl.getPhone()+"'}";
		}
		/*DBCursor dbCursor =collection.find(query);
		if(dbCursor.hasNext()){
			userdtl=(UserDtl) dbCursor.next();
			
		}*/
		BasicQuery query=new BasicQuery(queryObject);
		userdtl =mongoTemplate.findOne(query,UserDtl.class );
		

		return userdtl;
	}

	@Override
	public UserDtl getUserDtl(String email) {
		//BasicQuery query=new BasicQuery();
		String queryObject = "";
		queryObject = "{'email' : '"+email+"'}";
		BasicQuery query=new BasicQuery(queryObject);
		UserDtl userdtl = mongoTemplate.findOne(query,UserDtl.class );
		
		return userdtl;
	}

	@Override
	public List<PlaceOrder> getPlaceOrderDtl(String emailId) {
		String queryObject = "";
		queryObject = "{'email' : '"+emailId+"'}";
		BasicQuery query=new BasicQuery(queryObject);
		List<PlaceOrder> placeOrder = mongoTemplate.find(query,PlaceOrder.class );
		
		return placeOrder;
	}


}
