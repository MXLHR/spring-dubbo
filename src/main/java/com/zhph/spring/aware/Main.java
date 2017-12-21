package com.zhph.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.aware.config.AwareConfig;
import com.zhph.spring.aware.service.AwareService;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		
		AwareService awareService = context.getBean(AwareService.class);
		awareService.outputResult();
		
		context.close();
		
	}

}
