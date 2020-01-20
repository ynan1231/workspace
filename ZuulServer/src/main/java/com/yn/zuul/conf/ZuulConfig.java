package com.yn.zuul.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yn.zuul.filter.AuthorizedRequestFilter;


@Configuration
public class ZuulConfig {
    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter() {
        return new AuthorizedRequestFilter() ;
    }
}
