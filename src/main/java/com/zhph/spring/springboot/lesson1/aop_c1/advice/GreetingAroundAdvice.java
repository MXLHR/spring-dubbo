package com.zhph.spring.springboot.lesson1.aop_c1.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class GreetingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		after();
		Object result = invocation.proceed();
		before();
		return result;
	}
	
	private void after(){
		System.out.println("after GreetingAroundAdvice");
	}
	
	private void before(){
		System.out.println("before GreetingAroundAdvice" );
	}

}
