package com.zhph.spring.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.zhph.spring.aop.annotation.Action;

@Aspect
@Component
public class LogAspect {
	
	@Pointcut("@annotation(com.zhph.spring.springboot.lesson1.aop.Action)")
	public void annotationPointCut(){};
	
	@After(value = "annotationPointCut()")
	public void after(JoinPoint jp){
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("after.. 注解式拦截 ---> "+ action.name());
		
	};
	
	@Before(value = "execution(* com.zhph.spring.springboot.lesson1.aop..*.*(..))")
	public void before(JoinPoint jp){
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method method = signature.getMethod();
		System.out.println("before..方法规则拦截 ---> "+method.getName());
	};
	

}
