package com.fsd2020.emart.filter;

import com.fsd2020.emart.entity.Audience;
import com.fsd2020.emart.jwt.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StreamUtils;

public class LoginFilter extends ZuulFilter {
	
	@Autowired
    private Audience audience;
	
	private static Logger log = LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public String filterType() {

		return FilterConstants.POST_TYPE;
	}
	
	@Override
	public int filterOrder() {

		return 1;
	}
	
	@Override
	public boolean shouldFilter() {

		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    // no check
	    if ("/user/login".equalsIgnoreCase(request.getRequestURI())) {
	    	return true;
	    } else  {
	    	return false;
	    }

	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    
	    String userId = request.getParameter("userId");
	    
		try {		    
		    InputStream stream = ctx.getResponseDataStream();
	        String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
		    
		    log.info("body=" + body);
	
		    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	        
	        if ("true".equals(body)) {
	        	
	        	String token = JwtTokenUtil.createJWT(userId,audience);
			    log.info("token=" + token);	        	
	        	ctx.addZuulResponseHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
	        	
	        	ctx.setResponseBody(body);
	            
	        } 
		} catch (IOException e) {
            e.printStackTrace();
        }

		ctx.setSendZuulResponse(true);
	    return null;
	}


}
