package com.zhph.spring.teskexecutor.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com.zhph.spring.teskexecutor.*")
@EnableAsync //开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer{

	/*
	 * 配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，
	 * 这样我们就获得了一个基于线程池的TaskExecutor.
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

	/*
	 * spring  通过任务执行器TaskExecutor来实现多线程和并发编程。
	 * 通过配置类的@EnableAsync开启对异步任务的支持
	 * 并通过在实际执行的Bean的方法中使用@Async主键来声明其实一个异步任务
	 * 
	 */
}
