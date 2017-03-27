package com.lk.twentyOne;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@Path("/test")
@Produces("application/json")
public class TestAction {
	private static Logger log = LoggerFactory.getLogger(TestAction.class);
	
	@GET
	public String testApi() {
		log.info("測試接口");
		return "test helloworld!";
	}
	
	@GET
	@Path("/{param}")
	public String helloworld(@PathParam("param") String msg) throws IOException {
		log.info("測試參數接口，{}", msg);
		
		return String.format("param: %s", msg);
	}
	
	@POST
	@Path("/{param}")
	public String helloworldPost(String json) throws IOException {
		log.info("測試參數接口POST，{}", json);
		
		Param java = new Gson().fromJson(json, Param.class);
		
		System.out.println(java.value);
		System.out.println(java.value2);
		
		return String.format("{\"param\": \"%s\"}", json);
	}
	
	class Param {
		String value;
		String value2;
	}
	
}
