package com.yn.nacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 使用feign客户端必须引用@EnableFeignClients
 *
 */
@SpringBootApplication
@EnableFeignClients
public class AlibabaNacosDiscoveryClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosDiscoveryClient1Application.class, args);
	}

}
