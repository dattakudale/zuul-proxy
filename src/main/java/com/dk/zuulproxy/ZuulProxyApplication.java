package com.dk.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.dk.zuulproxy.filter.CustomZuulFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyApplication.class, args);
	}
	
	@Bean
	public CustomZuulFilter addResponseHeaderFilter() {
		return new com.dk.zuulproxy.filter.CustomZuulFilter();
	}
}
