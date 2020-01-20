package com.yn.nacos.client.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class RestTemplateAction {
	@Autowired
	RestTemplate restTemplate;
	  
	  @RequestMapping(value = "/templateTest", method = RequestMethod.GET)
      public String echo() {
		  
          String url = "http://alibaba-nacos-discovery-server/hello?name=didi2";
		String result =  restTemplate.getForObject(url  , String.class);
          log.info("Invoke : " + url + ", return : " + result);
          return "Invoke : " + url + ", return : " + result;
      }
}
