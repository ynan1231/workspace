package com.yn.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 启用配置中心
 * 1. 引入spring-cloud-starter-alibaba-nacos-config
 * 2. 必须在bootstrap.properties中配置spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 3. nacos中的配置中的data id必须与spring.application.name的值一致
 *4. @RefreshScope 可以实时刷新配置
 */
@SpringBootApplication
@EnableFeignClients
public class AlibabaNacosConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosConfigClientApplication.class, args);
	}

}
