package com.rainbow.common.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.rainbow.core.cache.CacheFactory;
import com.rainbow.module.wechat.AccessTokenMaker;

/**
 * Init function when App Start.
 * 
 * @author Ray
 */
@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {

	public InitServlet() {
		super();
	}

	public void init() throws ServletException {
		
		//load Init data for cache
		CacheFactory.initCache();
		
		new AccessTokenMaker().start();
	}

}
