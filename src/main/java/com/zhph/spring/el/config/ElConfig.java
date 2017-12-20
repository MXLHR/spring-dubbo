package com.zhph.spring.el.config;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

public class ElConfig {

	private String normal;
	
	
	private String osName;
	
	private double randomNumber;
	
	@Value("#{demoService.another }")
	private String fromAnother;
	
	private Resource testFile;
	
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	
}
