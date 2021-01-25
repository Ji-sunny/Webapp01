package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//annotation이 없으면 자동적으로 객체를 만들어지지 않음

@Service
public class Ch13Service7 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service7.class);
	
	//field
	@Value("${fileupload}") private String saveDirPath;
	
	//method
	public void method() {
		logger.info("실행");
		logger.info("fileupload: " + saveDirPath);
	}
}
