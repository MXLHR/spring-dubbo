package com.zhph.spring.springboot.lesson1.aop_c1;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhph.spring.springboot.lesson1.aop_c1.advice.GreetingAroundAdvice;

public class MainTest {

	public static void main(String[] args) {

//		testShengmin();
//		testIntroductionAdvice();
//		testAopAdvisor();
//		testAopProxy2();
		testAopAspect();
		
	}
//	12. AspectJ execution 表达式拦截
	public static void testAopAspect(){
		ApplicationContext context = new ClassPathXmlApplicationContext("mytest3.xml");
		Greeting greetingImpl = (Greeting) context.getBean(GreetingImpl.class);
		greetingImpl.sayHello("声明式AOP");
//		greetingImpl.goodMorning("jia jia ");
		
	}
	
	// 11.AOP自动代理  （1）Spring框架自动生成代理
	public static void testAopProxy1(){
		//（1）Spring框架自动生成代理。
		ApplicationContext context = new ClassPathXmlApplicationContext("mytest2.xml");
		GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingImpl");
		greetingImpl.sayHello("声明式AOP");
		greetingImpl.goodMorning("jia jia ");
	}
	// 11.AOP自动代理  （1）Spring框架自动生成代理
	public static void testAopProxy2(){
		//（1）Spring框架自动生成代理。
		ApplicationContext context = new ClassPathXmlApplicationContext("mytest2.xml");
		GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingImpl");
		greetingImpl.sayHello("声明式AOP");
		greetingImpl.goodMorning("jia jia ");
	}
	
	//使用基于正则表达式的SpringAOP切面类
	public static void testAopAdvisor(){
		ApplicationContext context = new ClassPathXmlApplicationContext("mytest.xml");
		GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
		greetingImpl.sayHello("声明式AOP");
		greetingImpl.goodMorning("jia jia ");
//		Love love = (Love) greetingImpl; //引入 扩展的功能 将目标类强制向上转型为Love接口，这就是引入增强
//		love.display("jia jia");
	}
	
	public static void testIntroductionAdvice(){
		//引入。 对类的动态增强
		//（1）定义一个新接口Love
		//（2）定义授权引入增强类
		ApplicationContext context = new ClassPathXmlApplicationContext("mytest.xml");
		GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy2");
		greetingImpl.sayHello("声明式AOP");
		
		Love love = (Love) greetingImpl; //引入 扩展的功能 将目标类强制向上转型为Love接口，这就是引入增强
		love.display("jia jia");
	}
	
	public static void testShengmin(){
		ApplicationContext context = new ClassPathXmlApplicationContext("mytest.xml");
		Greeting greet2 = (Greeting) context.getBean("greetingImpl");
		Greeting greet = (Greeting) context.getBean("greetingProxy");
		greet.sayHello("声明式AOP");
		
		/*
		 * 上面的增强仅仅是对方法增强，也就是织入.
		 * 对类的增强才能叫做引入增强
		 * 
		 * 比如说我不想让GreetingImpl去直接实现Greeting接口，
		 * 因为这样的话，我就必须去实现他的方法。这时我就能靠Spring引入增强来帮我动态实现
		 * 
		 */
	}
	
	public void testBianchen(){
		//编程式增强
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());//目标类
		proxyFactory.addAdvice(new GreetingAdvice());//增加通知1，增强（前置增强，后置增强）
		proxyFactory.addAdvice(new GreetingAroundAdvice());//增加通知2
		
		Greeting greet = (Greeting) proxyFactory.getProxy();//获得代理实例
		greet.sayHello("鲜磊。");
	}
}
