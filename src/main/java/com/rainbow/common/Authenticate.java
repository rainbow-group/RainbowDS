package com.rainbow.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.rainbow.common.beans.User;
import com.rainbow.core.cache.CacheFactory;
import com.rainbow.core.jwt.JWTBase;

/**
 * Core Authenticate Class
 * 
 * @author Ray
 * 
 */
public class Authenticate {
	final static Logger logger = LogManager.getLogger(Authenticate.class);

	final public String requestToken(User user) {
		String token = null;
		if (user != null) {
			token = CacheFactory.getCache().getToken(user.getLoginName());
			if (token == null) {
				token = JWTBase.createToken(getClaims(user));
				CacheFactory.getCache().putToken(user.getLoginName(), token);
			}
			CacheFactory.getCache().putRequestToken(token, new Date().getTime());
		}

		return token;
	}

	final public static boolean verifyToken(String token) {
		DecodedJWT dJwt = JWTBase.verifyToken(token);
		boolean isVerfied = false;
		if (dJwt != null) {
			if (token.equals(
					CacheFactory.getCache().getToken(dJwt.getClaim(Constants.JWT_CLAIMS_USER_LOGIN_NAME).asString()))) {
				isVerfied = true;
			}
		}
		return isVerfied;
	}

	public static final boolean verfiyTimeout(String token) {
		boolean isVerfied = false;
		if (new Date().getTime() - CacheFactory.getCache().getRequestToken(token) < CacheFactory.LOGIN_TIMEOUT) {
			isVerfied = true;
		}
		return isVerfied;
	}

	private Map<String, String> getClaims(User user) {
		Map<String, String> claims = new HashMap<String, String>();

		claims.put(Constants.JWT_CLAIMS_USER_EMAIL, user.getEmail());
		claims.put(Constants.JWT_CLAIMS_USER_LOGIN_NAME, user.getLoginName());
		claims.put(Constants.JWT_CLAIMS_USER_NAME, user.getName());
		claims.put(Constants.JWT_CLAIMS_USER_PHONE, user.getPhone());

		return claims;

	}

}
