package com.zhph.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

	/**
	 * 作者
	 */
	String author() default "xianlei";
	/**
	 * 日期
	 */
	String date();
	/**
	 * 版本
	 */
	int revsion() default 1;
	/**
	 * 批注，评论，说明
	 */
	String comments();
}
