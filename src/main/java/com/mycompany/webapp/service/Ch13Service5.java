package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.DAO.Ch13BoardDao1;
import com.mycompany.webapp.DAO.Ch13BoardDao2;
import com.mycompany.webapp.DAO.Ch13BoardDao3;
import com.mycompany.webapp.DAO.Ch13BoardDao4;

//관리객체로 만들어져있는지 확인
@Service
//@Component
public class Ch13Service5 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service5.class);
	
	
	//field
	@Resource private Ch13BoardDao1 boardDao1;
	@Resource private Ch13BoardDao2 boardDao2;
	@Resource private Ch13BoardDao3 boardDao3;
	@Resource private Ch13BoardDao4 boardDao4;
	
	public void method() {
		logger.info("실행");
		boardDao1.select();
		boardDao2.select();
		boardDao3.select();
		boardDao4.select();
	}
}
