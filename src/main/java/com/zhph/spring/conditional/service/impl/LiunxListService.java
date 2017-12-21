package com.zhph.spring.conditional.service.impl;

import com.zhph.spring.conditional.service.ListService;

public class LiunxListService implements ListService {

	@Override
	public String showListCmd() {
		
		return "ls";
	}

}
