package com.yn.demo.client.hystrix;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.yn.demo.client.AddServiceClient;
/**
 * 熔断类
 * @author wyn
 *需加入配置 feign.hystrix.enabled=true
 */
@Component
public class AddServiceClientHystrix implements AddServiceClient{

	public Integer add( Integer a,Integer b) {
		return 10000000;
	}

	@Override
	public Integer add2() {
		return 2000000;
	}

}
