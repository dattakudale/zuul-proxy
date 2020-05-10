package com.dk.zuulproxy.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class CustomZuulFilter extends ZuulFilter {

	  private static Logger log = LoggerFactory.getLogger(CustomZuulFilter.class);
	
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		
		HttpServletRequest request = context.getRequest();
		
		String token = request.getHeader("JWT");
		
		log.info("JWT : "+token);
		
		HttpServletResponse servletResponse = context.getResponse();
		servletResponse.addHeader("CustomHeader", UUID.randomUUID().toString());
		return null;
	}

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public int filterOrder() {

		return 999;
	}

	@Override
	public String filterType() {

		return "pre";
	}

}
