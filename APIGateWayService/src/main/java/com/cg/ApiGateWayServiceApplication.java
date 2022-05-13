package com.cg;

import org.springframework.boot.SpringApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class ApiGateWayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayServiceApplication.class, args);
	}

}
