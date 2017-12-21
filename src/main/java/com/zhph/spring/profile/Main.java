package com.zhph.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.profile.config.ProfileConfig;
import com.zhph.spring.profile.service.SmsService;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * 在不同的环境下适用不同的配置 。
		 * 
		 * 1）通过设定Environment 的ActiveProfiles 来设定当前的context 需要配置的环境。
		 * 开发中适用@Profile注解类或者方法，达到在不同情况下选择实例化不同的Bean.
		 * 2)通过设定Jvm的spring.profiles.active 参数来设置配置环境、
		 * 3) Web项目设置在Servlet的Context parameter中。
		 */
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//---
		context.getEnvironment().setActiveProfiles("prod");
		context.register(ProfileConfig.class);//后置注册Bean配置类，不然会报Bean的异常
		context.refresh();
		//-
		
		SmsService smsService = context.getBean(SmsService.class);
		smsService.sendRepayLoanSuccess("17628293568", "[正合钱包]尊敬的客户你好，今天是你的还款日...");
		
	}

}
