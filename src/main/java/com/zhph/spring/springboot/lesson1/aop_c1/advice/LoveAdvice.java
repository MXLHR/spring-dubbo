package com.zhph.spring.springboot.lesson1.aop_c1.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

import com.zhph.spring.springboot.lesson1.aop_c1.Love;

@Component
public class LoveAdvice extends DelegatingIntroductionInterceptor implements Love{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		return super.invoke(mi);
	}
	
	@Override
	public void display(String name) {
		
		System.out.println("say love : " + name);
		
	}

}
