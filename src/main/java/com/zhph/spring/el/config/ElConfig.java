package com.zhph.spring.el.config;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.zhph.spring.el.*")
@PropertySource("classpath:com/zhph/spring/el/test.properties")
public class ElConfig {
	
	/*
	 * 注入配置配件需使用@PropertySource 指定文件地址，
	 * 若使用@Value注入,则需要配置一下PropertySourcesPlaceholderConfigurer的Bean.
	 * 
	 * 注意，@Value("${book.name}")使用的是$而不是#
	 * 
	 */

	@Value("I Love You ! ")//注入普通属性
	private String normal;
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")//EL 指定包计算
	private double randomNumber;
	
	@Value("#{personService.another }")//# bean.filed
	private String fromAnother;
	
	@Value("classpath:com/zhph/spring/el/test2.txt")//uri  本地文件
	private Resource testFile;
	
	@Value("http://www.baidu.com") //uri 封装成Resource
	private Resource testUrl;
	
	@Value("${book.name}")//读取配置文件的值
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public void outputResource() {
		
		System.out.println("变量[normal] : "+ normal);
		System.out.println("osname : " + osName);
		System.out.println("randomNumber : "+ randomNumber);
		System.out.println("fromAnother : " + fromAnother);
		try {
			System.out.println("testFile.inputStream :" + IOUtils.toString(testFile.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
