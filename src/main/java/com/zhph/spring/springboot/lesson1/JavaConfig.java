package com.zhph.spring.springboot.lesson1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//1
public class JavaConfig {
	
	@Bean//2
	public FunctionService functionService() {
		return new FunctionService();
	}

	@Bean
	public UseFunctionService useFunctionService() {
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService());//3
		return useFunctionService;
	}
	
	@Bean
	public UseFunctionService useFunctionService2(FunctionService functionService) {
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService);//4
		return useFunctionService;
	}
	
	//此处没有用包扫描，因为所有的Bean都在这个类中定义了。(不需要包扫描Bean)
	//使用@Configuration注解表名当前类是一个配置类
	//使用@Bean注解声明当前方法的返回值是一个Bean,Bean的名称是方法名
	
	//3.依赖注入直接调用functionService()返回一个Bean
	//4.另一种注入方式，把Bean作为参数传入，这个也是极好的功能

}
