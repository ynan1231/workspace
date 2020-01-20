package com.yn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServerProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerProvideApplication.class, args);
	}

}
