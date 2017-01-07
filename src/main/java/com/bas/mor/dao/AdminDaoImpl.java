package com.bas.mor.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Component;

import com.bas.mor.model.PlaceOrder;
import com.bas.mor.mongo.repo.LoginRepo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Component(value="adminDao")
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	LoginRepo loginRepo;

	@Override
	public List<PlaceOrder> getOrderDtlForAdmin() {
		String queryObject = "";
		queryObject = "{'status':{'$nin':['deliverd']}}";
		BasicQuery query=new BasicQuery(queryObject);
		List<PlaceOrder> placeOrder = mongoTemplate.find(query,PlaceOrder.class );
		
		return placeOrder;
	}

	@Override
	public void saveStatus(String ordId, String status) {
		
		DBCollection collection = mongoTemplate.getCollection("order_dtl");
		
		/*BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("status", status);*/
		
		BasicDBObject updateDocument = new BasicDBObject();
		  updateDocument.append("$set", new BasicDBObject().append("status", status));

		ObjectId objId = new ObjectId(ordId);
		BasicDBObject searchQuery = new BasicDBObject().append("_id", objId);

		collection.update(searchQuery, updateDocument);
		
		//mongoTemplate.updateFirst(query, $, entityClass)
		
	}

}
