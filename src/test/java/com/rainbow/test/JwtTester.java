package com.rainbow.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.Authenticate;

public class JwtTester {

	final static Logger logger = LogManager.getLogger(JwtTester.class);

	public static void main(String[] args) {

//		Authenticate auth = new Authenticate();

//		String token = auth.requestToken("ray", "ray");
//
//		logger.info(token);

		logger.info(Authenticate.verifyToken("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJSYWluYm93IEdyb3VwIiwibmFtZSI6IlJheSIsImxvZ2luIjoiYWRtaW4ifQ.nHVBpdY6Grk5-MN0lWXyq8E52HodM9rAjhHMsa6S6Vo"));
	}

}
