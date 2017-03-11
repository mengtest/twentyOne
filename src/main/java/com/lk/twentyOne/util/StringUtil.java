package com.lk.twentyOne.util;

public class StringUtil {

	public static boolean isEmpty(String s) {
		if (null == s || s.length() == 0) {
			return true;
		}
		return false;
	}
}
