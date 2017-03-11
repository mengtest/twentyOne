package com.lk.twentyOne.util;

import static org.junit.Assert.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.bson.Document;
import org.junit.Test;

import com.google.gson.Gson;
import com.lk.twentyOne.javabean.UserInfo;

public class MongoUtilTest {

	@Test
	public void test() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		UserInfo java = new UserInfo();
		java.setId("id2");
		java.setNickname("nickname2");
		java.setEmail("email2");
		java.setUsername("username2");
		java.setCreateDate(new Date());
		java.setUpdateDate(new Date());
		
		Map<String, Object> map = PropertyUtils.describe( java );
		
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		System.out.println("================");
		
		// 筛选是否需要解析内部的bean值
		PropertyDescriptor[] descriptors=PropertyUtils.getPropertyDescriptors( java );
		for (PropertyDescriptor descriptor : descriptors) {
			System.out.println(String.format("%14s, %18s, %14s", descriptor.getName(), descriptor.getPropertyType().getName(), descriptor.getPropertyType().getCanonicalName()));
		}
	}
	
	@Test
	public void jsonToDocument() {
		UserInfo java = new UserInfo();
		java.setId("id2");
		java.setNickname("nickname2");
		java.setEmail("email2");
		java.setUsername("username2");
		java.setCreateDate(new Date());
		java.setUpdateDate(new Date());
		
		Gson gson = JsonUtil.getGson();
		Document parse = Document.parse(gson.toJson(java));
		
		System.out.println(parse);
		System.out.println(parse.toJson());
		
		UserInfo java2 = gson.fromJson(parse.toJson(), UserInfo.class);
		System.out.println(java2);
	}

}
