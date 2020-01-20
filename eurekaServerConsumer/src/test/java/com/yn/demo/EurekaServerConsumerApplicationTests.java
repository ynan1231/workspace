package com.yn.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Resource
	private RestTemplate restTemplate;
	@Resource
	private HttpHeaders httpHeaders;
	public static final String URL = "http://localhost:8081/add2";
	@Test
	public void securityTest() {
		ResponseEntity<Integer>  result = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity(httpHeaders), Integer.class);
		System.out.println(result);
		System.out.println(result.getBody());
	}
}
