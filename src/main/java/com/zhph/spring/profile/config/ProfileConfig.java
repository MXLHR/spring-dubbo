package com.zhph.spring.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zhph.spring.profile.service.SmsService;
import com.zhph.spring.profile.service.impl.SmsServiceImpl;

@Configuration
public class ProfileConfig {
	
	private static final String DEV_SEND_URL = "http:www.baidu.com/test";
	private static final String PROD_SEND_URL = "http:www.baidu.com";
	
	@Bean
	@Profile(value="dev") 
	public SmsService sendDevService(){
		return new SmsServiceImpl(DEV_SEND_URL);
	}
	@Bean
	@Profile(value="prod")
	public SmsService sendProdService(){
		return new SmsServiceImpl(PROD_SEND_URL);
	}

}
