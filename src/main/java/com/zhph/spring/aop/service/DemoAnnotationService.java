package com.zhph.spring.aop.service;

import org.springframework.stereotype.Service;

import com.zhph.spring.aop.annotation.Action;
/**
 * 拦截类
 * 
 * @author sanely
 */
@Service
public class DemoAnnotationService {

	@Action(name = "add拦截")
	public void add(){
		System.out.println(" add method id run ");
	}
}
