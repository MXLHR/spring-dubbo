package com.zhph.spring.test.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.zhph.spring.test.service.UserService;
import com.zhph.spring.test.service.bean.User;

public class UserServiceImpl implements UserService {

	List<User> users = new LinkedList<User>();

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void delete(int index) {
		users.remove(index);
	}

	@Override
	public String toString() {
		for(User u : users){
			System.out.println("name :" + u.getName() + " ， sex : "+ u.getSex());
		}
		return "UserServiceImpl [users=" + users + "]";
	}
	

}
