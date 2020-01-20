package com.yn.nacos.client.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloAction {
	  @GetMapping("/hello")
      public String hello() {
          return "didispace.com";
      }
}
