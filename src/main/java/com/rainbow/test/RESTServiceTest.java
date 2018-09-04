package com.rainbow.test;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rainbow.common.beans.User;
import com.rainbow.common.util.JsonUtil;
import com.rainbow.core.cache.CacheFactory;



@Path("/in/tester")
public class RESTServiceTest {
	final static Logger logger = LogManager.getLogger(RESTServiceTest.class);

	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTest() {

		ObjectMapper mapper = new ObjectMapper();

		String jsonStr = "";
		User user = new User();

		user.setId(1L);
		user.setName("Tim");
		try {
			jsonStr = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		jsonStr = JsonUtil.getJsonStr(CacheFactory.getCache().getAllCachedToken());

		return Response.status(200).entity(jsonStr).build();
	}

	@Path("/post")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postTest(User user) {

		logger.info("In User ==> ");
		String jsonStr = "";
		user.setName("Ray");
		jsonStr = JsonUtil.getJsonStr(user);

		return Response.status(200).entity(jsonStr).build();
	}
}
