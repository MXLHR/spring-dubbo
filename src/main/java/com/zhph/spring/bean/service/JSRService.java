package com.zhph.spring.bean.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSRService {

	public JSRService() {
		super();
		System.out.println(this.getClass() + "-- > 构造初始化");
	}
	@PostConstruct
	public void init(){
		System.out.println(this.getClass() + " --- > init ");
	}
	
	public void sayHello(String name){
		System.out.println( " [JSRService] hello " + name );
	}
	
	@PreDestroy
	public void destory(){
		System.out.println(this.getClass() + "--- > destory ");
	}
	
	

}
