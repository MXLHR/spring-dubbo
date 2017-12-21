package com.zhph.spring.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	
	String name();
	
	//1.@Documented 制定拥有这个注解的元素可以被javadoc工具文档化
	//@Target--指明该类型的注解可以注解的程序元素的范围。该元注解的取值为
	//Type,Method,Construtor,Field等。 如果Target元素没有出现，那么定义的注解可以应用到任何地方。
	//@Inherited 指明该注解类型被自动继承。
	//@Retention 指明了该Annotation被保留的时间长短。取值范围是 Source,Class,Runtime
	
	
	//Java内建注解
	//Java提供了三种内建注解
	
	/*
	 * @Override  重写、覆盖
	 * 
	 * @Deprectated 不建议使用该方法
	 * 
	 * @SuppressWarnings 告诉编译器忽略特定的警告信息  保留策略是SOURCE,被编译器丢弃
	 * 
	 * 
	 */
	


}
