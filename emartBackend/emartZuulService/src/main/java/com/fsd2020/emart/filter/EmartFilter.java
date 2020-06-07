package com.fsd2020.emart.filter;

import com.fsd2020.emart.jwt.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class EmartFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(EmartFilter.class);

	@Override
	public String filterType() {

		return FilterConstants.PRE_TYPE;
	}
	
	@Override
	public int filterOrder() {

		return 1;
	}
	
	@Override
	public boolean shouldFilter() {

		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    // have note check
	    if ("/user/login".equalsIgnoreCase(request.getRequestURI())) {
	    	return false;
	    } else if ("/user/sellerSignUp".equalsIgnoreCase(request.getRequestURI())) {
	    	return false;
	    } else if ("/user/buyerSignUp".equalsIgnoreCase(request.getRequestURI())) {
	    	return false;
	    } else if (request.getRequestURI().indexOf("images") > 0) {
	    	return false;
	    } else {
	    	return true;
	    }
	    
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    
        Object token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        
        if (token == null) {
        	ctx.setSendZuulResponse(true);
//            log.warn("access token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
        } else {
        	ctx.setSendZuulResponse(true);
        }

	    return null;
	}


}
