package com.zhph.spring.teskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhph.spring.aware.config.AwareConfig;
import com.zhph.spring.aware.service.AwareService;
import com.zhph.spring.teskexecutor.config.TaskExecutorConfig;
import com.zhph.spring.teskexecutor.taskservice.AsyncTaskService;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		
		AsyncTaskService taskService = context.getBean(AsyncTaskService.class);
		
		for(int i=0 ; i<10 ; i++){
			taskService.executeAsyncTask(i);
		}
		for(int i=0 ; i<10 ; i++){
			taskService.executeAsyncTaskPlus(i);
		}
		
		//测试结果，这个任务时并发执行的而不是按照顺序执行的
		
		context.close();
		
	}

}
