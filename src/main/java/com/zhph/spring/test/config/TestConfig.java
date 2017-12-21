package com.zhph.spring.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhph.spring.test.service.UserService;
import com.zhph.spring.test.service.impl.UserServiceImpl;

@Configuration
public class TestConfig {

	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}
	
}
