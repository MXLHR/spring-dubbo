package com.zhph.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.di.config.Config;
import com.zhph.spring.di.service.UseFunctionService;

public class Main {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		UseFunctionService ufs =  (UseFunctionService) context.getBean("useFunctionService");
		
		System.out.println(ufs.getFunctionService().sayHello("hello"));
		
		context.close();
		
	}
}
