package com.yn.demo.controller;

import javax.annotation.Resource;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yn.demo.client.AddServiceClient;

@RestController
public class AddAction {
	@Resource
	AddServiceClient client;
	@Resource
	HttpHeaders Headers;
	 @Resource
	 private DiscoveryClient discoveryClient ; // 进行Eureka的发现服务

	
	@GetMapping("/add")
//	 @HystrixCommand(fallbackMethod = "getFallback") //命令式熔断 需引入starter-netflix-hystrix
	public Integer name() {
		return client.add(1, 1);
	}
	
	
	@GetMapping("/add2")
	public Integer name2() {
		return client.add2();
	}
	public Integer getFallback() {
		return 100000;
	}
	@GetMapping("/client")
	public Object client() {
		return discoveryClient;
	}
}
