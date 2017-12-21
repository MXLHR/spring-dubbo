package com.zhph.spring.aware.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
	
	private String name;
	private ResourceLoader resourceLoader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	
	public void outputResult(){
		System.out.println("Bean的名称："+ name);
		Resource resource = resourceLoader.getResource("classpath:com/zhph/spring/aware/test.txt");
		
		try {
			System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 1. 实现BeanNameAware, ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
	 * 2. 实现ResourceLoaderAware 要重写 setResourceLoader.
	 * 3. 实现BeanNameWare 需重写setBeanName方法
	 */

}
