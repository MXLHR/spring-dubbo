package com.zhph.spring.el.service;

import org.springframework.beans.factory.annotation.Value;

public class PersonService {

	@Value("default xian ")
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}
	
	

}
