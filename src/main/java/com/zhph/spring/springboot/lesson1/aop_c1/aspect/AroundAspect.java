package com.zhph.spring.springboot.lesson1.aop_c1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	//GreetingImpl.*(..)  这个类的所有方法
	@Around("execution(* com.zhph.spring.springboot.lesson1.aop_c1.GreetingImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		before();
		Object result = pjp.proceed();
		after();
		return result;
	}
	
	private void before(){
		System.out.println("before...");
	}
	
	private void after(){
		System.out.println("after...");
	}

}
