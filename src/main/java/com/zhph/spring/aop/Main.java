package com.zhph.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.aop.service.DemoAnnotationService;
import com.zhph.spring.aop.service.DemoMethodService;

public class Main {
	
	public static void main(String[] args) {
		
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		
	DemoAnnotationService annotationService =  (DemoAnnotationService) context.getBean(DemoAnnotationService.class);
	DemoMethodService methodService =  (DemoMethodService) context.getBean(DemoMethodService.class);
		
	annotationService.add();
	methodService.add();
	
	context.close();
	
	}

}
