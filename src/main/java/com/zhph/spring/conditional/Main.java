package com.zhph.spring.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.aware.config.AwareConfig;
import com.zhph.spring.aware.service.AwareService;
import com.zhph.spring.conditional.config.ConditionConfig;
import com.zhph.spring.conditional.service.ListService;
import com.zhph.spring.teskexecutor.config.TaskExecutorConfig;
import com.zhph.spring.teskexecutor.taskservice.AsyncTaskService;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		
		Object object = context.getBean("string1");
		System.out.println(object);
		
		ListService listService = (ListService) context.getBean(ListService.class);
		
		System.out.println(context.getEnvironment().getProperty("os.name")+" : "+listService.showListCmd());
		
		context.close();
		
	}
	/*
	 * spring 4 提供了更通用的的基于条件的Bean的创建，即使用@Conditional注解
	 * 
	 * @Conditional 根据满足某已特定条件创建一个特定的Bean.
	 * 比如，当某一个jar包在某一个类路径下的时候，自动配置一个或多个Bean
	 * 
	 * 或者只有某个Bean被创建才会创建另外一个Bean ,根据特定条件来控制Bean的创建行为，这样我们可以利用这样的 特性进行一些自动的配置。
	 * spring Boot 会大量的应用到条件主键。
	 * 
	 */

}
