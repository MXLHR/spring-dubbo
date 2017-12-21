package com.zhph.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zhph.spring.bean.service.JSRService;
import com.zhph.spring.bean.service.UserService;


@Configuration
@ComponentScan("com.zhph.spring.beanInit.*")
public class Config {

	//配置文件需要注入Bean
	@Bean(initMethod="init",destroyMethod="destory")
	public UserService userService(){
		return new UserService();
	}
	@Bean
	public JSRService jsrService(){
		return new JSRService();
	}
	

}
