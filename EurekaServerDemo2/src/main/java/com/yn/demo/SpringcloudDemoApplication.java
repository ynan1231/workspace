package com.yn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * eureka注册中心
 * @author wyn
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringcloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDemoApplication.class, args);
	}

}
