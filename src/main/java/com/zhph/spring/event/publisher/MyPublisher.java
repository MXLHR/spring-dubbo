package com.zhph.spring.event.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.zhph.spring.event.event.MyEvent;

public class MyPublisher {
	
	@Autowired
	ApplicationContext applicationContext;
	
	public void publish(String msg){
		applicationContext.publishEvent(new MyEvent(this, msg));
	}

}
