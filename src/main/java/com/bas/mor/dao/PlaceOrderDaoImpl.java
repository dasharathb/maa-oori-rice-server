package com.bas.mor.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Component;

import com.bas.mor.model.PlaceOrder;
import com.bas.mor.mongo.repo.LoginRepo;
@Component(value="placeOrderDao")
public class PlaceOrderDaoImpl implements PlaceOrderDao{
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public void savePlaceDtl(PlaceOrder dtl) {

		mongoTemplate.save(dtl);
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
