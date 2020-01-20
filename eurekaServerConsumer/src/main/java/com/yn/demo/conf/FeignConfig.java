package com.yn.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;
@Configuration
//public class FeignConfig implements RequestInterceptor {
	/*
	 * @Override public void apply(RequestTemplate requestTemplate) {
	 * ServletRequestAttributes attributes = (ServletRequestAttributes)
	 * RequestContextHolder.getRequestAttributes(); HttpServletRequest request =
	 * attributes.getRequest(); //添加token requestTemplate.header("Authorization",
	 * request.getHeader("Authorization")); }
	 */
public class FeignConfig {
    @Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
	return new BasicAuthRequestInterceptor("admin", "1");//添加认证的用户名密码
	}
}
