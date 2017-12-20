package com.zhph.spring.springboot.lesson1.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	public void annotionPointCut(){
		
	};
	
	@After(value = "annotionPointCut()")
	public void after(){
		System.out.println("after..");
		
	};
	
	@Before(value = "")
	public void before(){
		System.out.println("before..");
	};
	

}
