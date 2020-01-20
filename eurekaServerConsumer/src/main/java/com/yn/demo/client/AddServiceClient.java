package com.yn.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yn.demo.client.hystrix.AddServiceClientHystrix;
import com.yn.demo.conf.FeignConfig;

@FeignClient(name = "eureka-provide",configuration = FeignConfig.class,fallback=AddServiceClientHystrix.class)//name大小写不敏感
public interface AddServiceClient {
	@GetMapping("/add/{a}/{b}")
	public Integer add(@PathVariable Integer a, @PathVariable Integer b);
	@GetMapping(value="/add2")
	public Integer add2();
}
