package com.lk.twentyOne.util;

import java.util.UUID;

public class StringUtil {

	public static boolean isEmpty(String s) {
		if (null == s || s.length() == 0) {
			return true;
		}
		return false;
	}
	
	public static String getUUID() {
		return getUUID("");
	}
	
	public static String getUUID(String prefix) {
		UUID uuid = UUID.randomUUID();
		return prefix + uuid.toString();
	}
}
