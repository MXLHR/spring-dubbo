package com.zhph.spring.springboot.lesson1.aop;

import org.springframework.stereotype.Service;
/**
 * 拦截类
 * 
 * @author sanely
 */
@Service
public class DemoMethodService {

	public void add(){
		System.out.println(" add method id run ");
	}
}
