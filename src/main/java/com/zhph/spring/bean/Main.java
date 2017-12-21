package com.zhph.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.bean.service.JSRService;
import com.zhph.spring.bean.service.UserService;


public class Main {
	
	/*
	 * 2.spring Bean的初始化和销毁  1）Java配置方式，使用 @Bean的 initMethod 和 destoryMethod 
			     2) 注解方式，利用JSR-250 的@PostConstruct 和@PreDestory
			配置类：@Bean(initMethod="init",destoryMethod="destory")
			
	<!-- https://mvnrepository.com/artifact/javax.annotation/jsr250-api -->
	<dependency>
	    <groupId>javax.annotation</groupId>
	    <artifactId>jsr250-api</artifactId>
	    <version>1.0</version>
	</dependency>

	 * 
	 */
	
	public static void main(String[] args) {
		
		//在创建Bean和销毁Bean的时候动态的增加方法。
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		UserService userService = context.getBean(UserService.class);
		
		JSRService jsrService = context.getBean(JSRService.class);
		
		
		userService.sayHello("xian lei ");
		jsrService.sayHello("xian lei jsr ");
		
		
		context.close();//容器销毁时候调用Bean 的 destory方法。 
		
	}

}
