package com.zhph.spring.teskexecutor.taskservice;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

	@Async//表明该方法是个异步方法，紫冬冬被注入使用ThreadPoolTaskExecutor 作为TaskExecutor
	public void executeAsyncTask(Integer i){
		System.out.println("【AsyncTaskService】 执行异步任务 : " + i);
	}
	
	public void executeAsyncTaskPlus(Integer i){
		System.out.println("【AsyncTaskService】 执行异步任务Plus : " + (i+10) );
	}
}
