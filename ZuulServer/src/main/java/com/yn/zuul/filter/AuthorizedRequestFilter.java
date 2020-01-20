package com.yn.zuul.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
public class AuthorizedRequestFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext() ; // 获取当前请求的上下文
        String auth = "admin:1"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        
        return null;
//        try {
//        	throw new RuntimeException("Exist some errors...");
////        	return null;
//		} catch (Exception e) {
//			throw new ZuulRuntimeException(e);
//		}
        
//			currentContext.setSendZuulResponse(false);//终止转发
        
    }
}
