package com.zhph.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhph.aop.aspect.LogAspect;
import com.zhph.aop.service.ArithmeticCalculator;
import com.zhph.aop.service.ArithmeticCalculatorImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mytest3.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
		System.out.println(arithmeticCalculator.getClass());

		int result = arithmeticCalculator.div(3, 0);
		System.out.println("result :" + result);
	}

}
