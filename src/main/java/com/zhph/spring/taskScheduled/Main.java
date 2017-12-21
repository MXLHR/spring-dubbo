package com.zhph.spring.taskScheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.aware.config.AwareConfig;
import com.zhph.spring.aware.service.AwareService;
import com.zhph.spring.taskScheduled.config.TaskScheduledConfig;
import com.zhph.spring.teskexecutor.config.TaskExecutorConfig;
import com.zhph.spring.teskexecutor.taskservice.AsyncTaskService;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskScheduledConfig.class);
		
		
		
		
	}

}
