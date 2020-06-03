package com.fsd2020.emart.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmartFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(EmartFilter.class);

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}
	
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    
	    ctx.setSendZuulResponse(true);

	    return null;
	}


}
