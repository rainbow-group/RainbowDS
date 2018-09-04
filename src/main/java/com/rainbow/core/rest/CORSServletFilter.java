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

/**
 * @author Ray
 *
 */
@WebFilter(filterName = "CorsFilter", urlPatterns = {"/*"})
public class CORSServletFilter implements Filter {
	
	@Override
	public void destroy() {
	}
	
 private void addHeadersFor200Response(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, authorization");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(response instanceof HttpServletResponse) {
			addHeadersFor200Response((HttpServletResponse)response);
			if(!((HttpServletRequest)request).getMethod().equals("OPTIONS"))
				chain.doFilter(request, response);
		}
		//chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
