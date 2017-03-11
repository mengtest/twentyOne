package com.lk.twentyOne;

import com.lk.twentyOne.user.UserService;
import com.lk.twentyOne.user.UserServiceImpl;

public class ServiceFactory {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}

}
