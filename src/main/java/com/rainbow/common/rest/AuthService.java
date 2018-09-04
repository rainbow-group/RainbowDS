package com.rainbow.common.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.Authenticate;
import com.rainbow.common.beans.User;
import com.rainbow.common.data.ModuleDAO;
import com.rainbow.common.data.UserDAO;
import com.rainbow.common.util.JsonUtil;

/**
 * 
 * @author Ray
 * 
 */
@Path("/auth")
public class AuthService {
	final static Logger logger = LogManager.getLogger(AuthService.class);

	private static final int STATUS_CODE_UNAUTHORIZED = 401;
	private static final int STATUS_CODE_LOGIN_TIMEOUT = 440;

	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(HashMap<String, String> loginParam) {

		String loginName = loginParam.get("loginName");
		String pwd = loginParam.get("pwd");

		Authenticate auth = new Authenticate();

		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByIdentity(loginName, pwd);

		if (user == null) {
			return Response.status(STATUS_CODE_UNAUTHORIZED).build();
		} else {
			String token = auth.requestToken(user);
			user.setToken(token);
			user.setPwd(null);
			ModuleDAO moduleDAO = new ModuleDAO();
			user.setAccessAbleModules(moduleDAO.getModulesByUid(user.getId()));

			return Response.status(200).entity(JsonUtil.getJsonStr(user)).build();
		}
	}

	@Path("/failed")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginFailed() {
		return Response.status(STATUS_CODE_UNAUTHORIZED).build();
	}

	@Path("/timeout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginTimeout() {
		return Response.status(STATUS_CODE_LOGIN_TIMEOUT).build();
	}
}
