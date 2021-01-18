package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//annotation이 없으면 자동적으로 객체를 만들어지지 않음

@Service
public class Ch13Service1 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service1.class);
	
	public void method() {
		logger.info("service1 method()");
	}
}
