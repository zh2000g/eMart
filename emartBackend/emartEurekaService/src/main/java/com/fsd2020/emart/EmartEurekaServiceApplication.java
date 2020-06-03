package com.fsd2020.emart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmartEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmartEurekaServiceApplication.class, args);
	}

}
