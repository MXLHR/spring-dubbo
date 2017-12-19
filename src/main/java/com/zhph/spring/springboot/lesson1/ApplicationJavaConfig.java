package com.zhph.spring.springboot.lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationJavaConfig {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		UseFunctionService ufs =  (UseFunctionService) context.getBean("useFunctionService");
		
		System.out.println(ufs.functionService.sayHello("hello"));
		
		context.close();
		
	}
}
