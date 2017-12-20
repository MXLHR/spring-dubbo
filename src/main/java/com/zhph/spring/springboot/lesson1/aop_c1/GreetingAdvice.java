package com.zhph.spring.springboot.lesson1.aop_c1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

//@Component
public class GreetingAdvice implements MethodBeforeAdvice, AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {

		System.out.println("after .. ");
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {

		System.out.println("before ...");
	}

}
