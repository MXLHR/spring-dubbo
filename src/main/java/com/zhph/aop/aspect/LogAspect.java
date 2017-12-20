package com.zhph.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	// 前置通知
	@Before("execution(* com.zhph.aop.service.*.*(..))") // execution(public *
	public void beforeMethod(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("【前置通知】The method 【" + methodName + "】begins with " + Arrays.asList(jp.getArgs()));
	}

	// 后置返回通知
	@AfterReturning(value = "execution(* com.zhph.aop..*.*(..))", returning = "result")
	public void afterReturningMethod(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName();
		System.out.println("【后置返回通知】The method 【" + methodName + "】 ends with 【" + result + "】");
	}

	// 后置通知
	@After("execution(* com.zhph.aop..*.*(..))")
	public void afterMethod(JoinPoint jp) {
		System.out.println("【后置通知】this is a afterMethod advice...");
	}

	// 异常通知
	@AfterThrowing(value = "execution(* com.zhph.aop..*.*(..))", throwing = "e")
	public void afterThorwingMethod(JoinPoint jp, NullPointerException e) {
		String methodName = jp.getSignature().getName();
		System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
	}

	// 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
	@Around(value = "execution(* com.zhph.aop.service.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object result = null;
		try {
			System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】begins with " + Arrays.asList(jp.getArgs()));
			// 执行目标方法
			result = jp.proceed();
			System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
		} catch (Throwable e) {
			System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
		}
		System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
		return result;
	}

}
