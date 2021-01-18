package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.DAO.Ch13BoardDao;

//관리객체로 만들어져있는지 확인
@Service
//@Component
public class Ch13Service6 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service6.class);
	
	
	//field
	@Autowired
	@Qualifier("Ch13boardDao5Qualifier")
	private Ch13BoardDao boardDao5;
	
	@Resource(name="ch13boardDao6")
	/* @Autowired
	 * @Qualifier("Ch13boardDao6Qualifier")*/
	private Ch13BoardDao boardDao6;

	
	public void method() {
		logger.info("실행");
		boardDao5.insert();
		boardDao6.insert();

	}
}
