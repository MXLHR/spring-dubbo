package com.zhph.spring.profile.service.impl;

import com.zhph.spring.profile.service.SmsService;

public class SmsServiceImpl implements SmsService {

	private String sendUrl;

	public SmsServiceImpl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	@Override
	public void sendRepayLoanSuccess(String phone, String content) {

		System.out.println("【短信发送URL:" + sendUrl + "】 phone : " + phone + " content :" + content);
	}

}
