package com.zhph.spring.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.el.config.ElConfig;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
		
		ElConfig resource = context.getBean(ElConfig.class);
		
		resource.outputResource();
		
		context.close();
		
	}
	
	
	/*
	 * Spring EL-Spring 表达式语言，支持在xml和注解中使用表达式，类似于JSP的EL表达式语言。
	 * 
	 * Spring开发中经常涉及调用各种资源的情况，包含普通文件、网址、配置文件、系统环境变量等。
	 * 
	 * Spring主要在注解@Value的参数中使用表达式
	 * 
	 * 注入普通字符，注入操作系统属性，注入表达式运算结果，注入其他Bean的属性，
	 * 注入文件内容，注入网址内容，注入属性文件
	 * 
	 */

}
