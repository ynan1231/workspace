package com.yn.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
	
}
