package com.lk.twentyOne;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/test")
@Produces("application/json")
public class TestAction {
	
	@GET
	public String testApi() {
		
		return "test helloworld!";
	}
	
	@GET
	@Path("/{param}")
	public String helloworld(@PathParam("param") String msg) throws IOException {
		
		return String.format("param: %s", msg);
	}
	
}
