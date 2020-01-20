package com.yn.nacos.server.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RestController
public class TestController {
//	@GetMapping(value="/hello")
	public String hello(String name) {
		log.info("invoked name="+name);
		return "hello	"+name;

	}
}
