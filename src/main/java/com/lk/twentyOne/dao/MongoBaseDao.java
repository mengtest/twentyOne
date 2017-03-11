package com.lk.twentyOne.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;

import com.lk.twentyOne.javabean.Id;
import com.lk.twentyOne.util.MongoUtil;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public abstract class MongoBaseDao<T extends Id> {
	
	/**
	 * 获取该对象T对应的mongodb collection名称
	 * @return
	 */
	public abstract String getCollectionName();

	public abstract Logger getLog();
	
	public String getDbName() {
		return MongoUtil.DB_NAME;
	}
	
	private MongoCollection<Document> getCollection() {
		return MongoUtil.getCollection(getDbName(), getCollectionName());
	}
	
	public void deleteMany(Bson filter) {
		getLog().info("从表 {} 删除多条数据，查询条件是: {}", getCollectionName(), filter);
		
		MongoCollection<Document> collection = getCollection();
		collection.deleteMany(filter);
	}
	
	public List<T> select(Bson filter, Bson sort, Class<T> clazz) {
		getLog().info("从表 {} 查询多条数据, 查询条件 {}, 排序条件 {}", getCollectionName(), filter, sort);
		
		List<T> list=new ArrayList<>();
		MongoCollection<Document> collection = getCollection();
		
		Block<Document> block = (t) -> {
			T java = MongoUtil.adaptToJava(t, clazz);
			list.add(java);
		};
		
		FindIterable<Document> find;
		if (null == filter) {
			if (null == sort) {
				find = collection.find();
			} else {
				find = collection.find().sort(sort);
			}
		} else {
			if (null == sort) {
				find = collection.find(filter);
			} else {
				find = collection.find(filter).sort(sort);
			}
		}
		
		find.forEach(block);
		return list;
	}
	
	public List<T> select(Bson filter, Bson sort, Class<T> clazz, int from, int size) {
		getLog().info("从表 {} 查询多条数据, 查询条件 {}, 排序条件 {}, 跳过: {}, 查询条数: {}", getCollectionName(), filter, sort, from, sort);
		
		List<T> list=new ArrayList<>();
		MongoCollection<Document> collection = getCollection();
		
		Block<Document> block = (t) -> {
			T java = MongoUtil.adaptToJava(t, clazz);
			list.add(java);
		};
		
		FindIterable<Document> find;
		if (null == filter) {
			if (null == sort) {
				find = collection.find();
			} else {
				find = collection.find().sort(sort);
			}
		} else {
			if (null == sort) {
				find = collection.find(filter);
			} else {
				find = collection.find(filter).sort(sort);
			}
		}
		
		find.skip(from).limit(size).forEach(block);
		return list;
	}
	
	public long selectCount(Bson filter) {
		getLog().info("从表 {} 查询记录数量, 查询条件 {}", getCollectionName(), filter);
		
		MongoCollection<Document> collection = getCollection();
		long count = 0;
		if(filter == null) {
			count = collection.count();
		} else {
			count = collection.count(filter);
		}
		
		return count;
	}

	public long selectCount() {
		return selectCount(null);
	}
	
	public T selectById(T java) {
		@SuppressWarnings("unchecked") Class<T> clazz=(Class<T>) java.getClass();
		Bson filter = new Document("id", java.getId());
		
		return selectOne(clazz, filter);
	}

	protected T selectOne(Class<T> clazz, Bson filter) {
		getLog().info("从表 {} 查询单条数据, 查询条件 {}", getCollectionName(), filter);
		
		MongoCollection<Document> collection = getCollection();
		Document document = collection.find(filter).first();
		
		if(document == null) {
			return null;
		} else {
			return MongoUtil.adaptToJava(document, clazz);
		}
	}
	
	public void updateById(T java) {
		Bson filter = getIdFilter(java);
		
		MongoCollection<Document> collection = getCollection();
		Document mongo = MongoUtil.adaptToMongo(java);
		
		getLog().info("向表 {} 更新数据，id: {}, 更改内容: {}", getCollectionName(), filter, mongo);
		collection.replaceOne(filter, mongo);
	}
	
	public void deleteById(T java) {
		Document filter = getIdFilter(java);
		MongoCollection<Document> collection = getCollection();
		
		getLog().info("从表 {} 删除单条数据，查询条件是: {}", getCollectionName(), filter);
		
		collection.deleteOne(filter);
	}
	
	public void save(T java) {
		Document document = MongoUtil.adaptToMongo( java );
		MongoCollection<Document> collection = getCollection();
		
		getLog().info("向表 {} 写入数据: {}", getCollectionName(), document);
		
		collection.insertOne(document);
	}
	
	public Document getIdFilter(T java) {
		String id = java.getId();
		
		if(isEmpty(id)) {
			getLog().warn("id值为空. id={}", id);
		}
		
		Document filter = new Document("id", id);
		return filter;
	}
	
	public static boolean isEmpty(String s) {
		if (null == s || s.length() == 0) {
			return true;
		}
		return false;
	}
}
