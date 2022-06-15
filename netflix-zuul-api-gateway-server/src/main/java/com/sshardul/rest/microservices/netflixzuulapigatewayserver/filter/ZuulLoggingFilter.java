package com.sshardul.rest.microservices.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		return true;//filter should anything or not
	}

	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {}, request url -> {}",request,request.getRequestURI() );
		return null;
	}

	@Override
	public String filterType() {
		return "pre";//when filter should execute before or after request
	}

	@Override
	public int filterOrder() {
		return 1;//filter piorioty
	}

}
