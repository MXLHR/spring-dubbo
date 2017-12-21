package com.zhph.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhph.spring.test.config.TestConfig;
import com.zhph.spring.test.service.UserService;
import com.zhph.spring.test.service.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class} )
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setName("xianlei3");
		user.setSex("man");
		userService.addUser(user);
		String listStr = userService.toString();
		System.out.println(listStr);
	}
	
	@Test
	public void testPringUser(){
		User user = new User();
		user.setName("xianlei");
		user.setSex("man");
		userService.addUser(user);
	}
	
	
}
