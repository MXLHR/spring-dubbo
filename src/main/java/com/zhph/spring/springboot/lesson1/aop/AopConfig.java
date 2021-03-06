package com.zhph.spring.springboot.lesson1.aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@ComponentScan("com.zhph.spring.springboot.lesson1.aop")
@EnableAspectJAutoProxy//开启Spring 对 Aspect的支持
public class AopConfig {

	
	
}
