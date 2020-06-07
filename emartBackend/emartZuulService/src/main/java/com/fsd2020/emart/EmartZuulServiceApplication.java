package com.fsd2020.emart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.fsd2020.emart.filter.EmartFilter;
import com.fsd2020.emart.filter.LoginFilter;

@SpringBootApplication
@EnableZuulProxy
public class EmartZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmartZuulServiceApplication.class, args);
	}
	
	@Bean
	public EmartFilter emartFilter() {
		return new EmartFilter();
	}
	
	@Bean
	public LoginFilter loginFilter() {
		return new LoginFilter();
	}

}
