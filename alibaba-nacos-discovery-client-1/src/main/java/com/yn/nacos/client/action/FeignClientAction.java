package com.yn.nacos.client.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yn.nacos.client.client.NacosFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FeignClientAction {
	@Autowired
	NacosFeignClient feignClient;
	
//	@Value("${didispace.title:gogo}")
    private String title;
	
	 @GetMapping("/feignTest")
	    public String test() {
	        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
	        String result = feignClient.hello(title);
	        log.info("Invoke :return : " + result);
	        return "Invoke : return : " + result;
	    }

}
