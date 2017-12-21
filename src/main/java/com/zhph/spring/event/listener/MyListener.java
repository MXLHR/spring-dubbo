package com.zhph.spring.event.listener;

import org.springframework.context.ApplicationListener;

import com.zhph.spring.event.event.MyEvent;

public class MyListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {
		
		String message = event.getMsg();
		
		System.out.println("监听者已经接受到了你的消息，"+ message);
		
	}

}
