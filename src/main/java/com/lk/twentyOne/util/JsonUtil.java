package com.lk.twentyOne.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	public static final String DATE_FORMAT="yyyyMMdd HH:mm:ss";
	private static Gson genericGson;
	
	static {
		genericGson=new GsonBuilder().setDateFormat(DATE_FORMAT).setPrettyPrinting().create();
	}
	
	public static Gson getGson() {
		return genericGson;
	}
}
