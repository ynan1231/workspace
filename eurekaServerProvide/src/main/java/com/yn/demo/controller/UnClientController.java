package com.yn.demo.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UnClientController {
	@GetMapping("/add2")
	public Integer noClient() {
		System.out.println("我被调用了/add2");
		return 80;
	}
}
