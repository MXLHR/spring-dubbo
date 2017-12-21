package com.zhph.spring.event.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent{

	/** serialVersionUID*/  
	private static final long serialVersionUID = 4851013742004020147L;
	
	private String msg;

	public MyEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
