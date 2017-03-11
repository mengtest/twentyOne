package com.lk.twentyOne.user;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.lk.twentyOne.ServiceFactory;
import com.lk.twentyOne.javabean.UserInfo;
import com.lk.twentyOne.util.JsonUtil;

@Path("/users")
@Produces("application/json")
public class UserAction {
	private static Logger log = LoggerFactory.getLogger(UserAction.class);
	
	@POST
	public String signin(String json) {
		log.info("用户登录, json: {}", json);
		
		Gson gson = JsonUtil.getGson();
		UserInfo java = gson.fromJson(json, UserInfo.class);
		
		UserService service = ServiceFactory.getUserService();
		java = service.signIn(java);
		
		return "test helloworld!";
	}
}
