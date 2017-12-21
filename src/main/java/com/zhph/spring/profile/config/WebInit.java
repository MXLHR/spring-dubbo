package com.zhph.spring.profile.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
/*
 * 
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.0.1</version>
    <scope>provided</scope>
</dependency>

 */
public class WebInit implements WebApplicationInitializer {
	
	private static final String PROFILE_DEV = "dev";
	private static final String PROFILE_PROD = "prod";

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		container.setInitParameter("spring.profile.default", PROFILE_DEV);
	}
}
