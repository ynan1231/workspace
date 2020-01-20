package com.yn.nacos.server.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="com.yn.nacos.server.dao")
public class CommonConf {

}
