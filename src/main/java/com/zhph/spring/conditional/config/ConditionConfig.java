package com.zhph.spring.conditional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.zhph.spring.conditional.conditional.LiunxCondition;
import com.zhph.spring.conditional.conditional.WindowsCondition;
import com.zhph.spring.conditional.service.ListService;
import com.zhph.spring.conditional.service.impl.LiunxListService;
import com.zhph.spring.conditional.service.impl.WindowsListService;

@Configuration 
public class ConditionConfig {

	@Bean
	public String string1(){
		return "test";
	}
	
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowsListService(){
		return new WindowsListService();
	}
	@Bean
	@Conditional(LiunxCondition.class)
	public ListService liunxListService(){
		return new LiunxListService();
	}
	
}
