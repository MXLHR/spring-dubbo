package com.zhph.spring.bean.service;

public class UserService {
	
	public UserService() {
		super();
		System.out.println(this.getClass() + "--- > 构造器初始化 ");
	}

	public void init(){
		System.out.println(this.getClass() + " --- > init ");
	}
	
	public void sayHello(String name){
		System.out.println( " hello " + name );
	}
	
	public void destory(){
		System.out.println(this.getClass() + "--- > destory ");
	}

}
