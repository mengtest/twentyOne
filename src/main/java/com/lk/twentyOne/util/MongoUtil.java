package com.lk.twentyOne.util;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.lk.twentyOne.javabean.WebOnly;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {
	public static Logger log = LoggerFactory.getLogger(MongoUtil.class);
	
	public static final String DB_NAME = "twentyOne";
	private static final String DB_HOST = "127.0.0.1";

	private static MongoClient mongoClient = new MongoClient(DB_HOST);
	private static Set<String> ignoreAnnotations;
	static {
		ignoreAnnotations = new HashSet<>();
		ignoreAnnotations.add(WebOnly.class.getCanonicalName());
	}
	
	public static MongoCollection<Document> getCollection(String dbName, String collName) {
		MongoDatabase database = mongoClient.getDatabase(dbName);
		MongoCollection<Document> collection = database.getCollection(collName);
		return collection.withWriteConcern(WriteConcern.W1);
	}
	
	public static Document adaptToMongo(Object java) {
//		Map<String, Object> bean2Map = BeanUtil.bean2Map(java, ignoreAnnotations);
//		Document document=new Document(bean2Map);
//		
//		return document;
		
		Gson gson = JsonUtil.getGson();
		return Document.parse(gson.toJson(java));
	}

	public static <T> T adaptToJava(Document t, Class<T> clazz) {
		Gson gson = JsonUtil.getGson();
		String json = gson.toJson(t);
		
		return gson.fromJson(json, clazz);
	}
	
}
