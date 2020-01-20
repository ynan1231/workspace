package com.yn.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient //不用此注解也会注册到注册中心
@RestController
public class DiscoverTestController {
	private static final Logger logger = LoggerFactory.getLogger(DiscoverTestController.class);
	@Resource
	private DiscoveryClient client;
	
	@GetMapping(value="/add/{a}/{b}")
	public Integer add(@PathVariable Integer a ,@PathVariable Integer b) {
		List<String> services = client.getServices();
		logger.info(services.toString());
		
		Integer rInteger = a +b;
		return rInteger;	
	}
	
	@GetMapping(value="/aadds/{a}")
	public Integer add2(@PathVariable("a") Integer a) {
		List<String> services = client.getServices();
		logger.info(services.toString());
		
		Integer rInteger = a +100;
		return rInteger;	
	}
	
}
