package com.zhph.spring.taskScheduled.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.zhph.spring.taskScheduled.*")
@EnableScheduling//开启定时任务
public class TaskScheduledConfig {

}
