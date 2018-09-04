package com.rainbow.core.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.Authenticate;

/**
 * Filter for Auth request.
 * 
 * @author Ray
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "/api/in/*" })
public class AuthenticateFilter implements Filter {
	final static Logger logger = LogManager.getLogger(AuthenticateFilter.class);

	private static final String AUTH_HEADER_KEY = "Authorization";
	private static final String AUTH_HEADER_VALUE_PREFIX = "Bearer ";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String token = getBearerToken(req);
		if (token != null && !token.trim().equals("")) {

			if (!Authenticate.verifyToken(token)) {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(request.getServletContext().getContextPath() + "/api/auth/failed");
				return;
			} else if (!Authenticate.verfiyTimeout(token)) {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(request.getServletContext().getContextPath() + "/api/auth/timeout");
				return;
			}

			chain.doFilter(request, response);
		} else {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(request.getServletContext().getContextPath() + "/api/auth/failed");
			return;
		}
	}

	@Override
	public void destroy() {
		logger.info("Authenticate Filter is destoried.");

	}

	private String getBearerToken(HttpServletRequest request) {
		String authHeader = request.getHeader(AUTH_HEADER_KEY);
		if (authHeader != null && authHeader.startsWith(AUTH_HEADER_VALUE_PREFIX)) {
			return authHeader.substring(AUTH_HEADER_VALUE_PREFIX.length());
		}
		return null;
	}

}
