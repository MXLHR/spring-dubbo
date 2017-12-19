package com.zhph.spring.springboot.lesson1;

public class UseFunctionService {

	FunctionService functionService;

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	//此处没有用@Service生命Bean
	//此处没有用@Autowired注解注入Bean
}
