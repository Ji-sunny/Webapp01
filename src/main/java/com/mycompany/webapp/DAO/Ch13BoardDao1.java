package com.mycompany.webapp.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.controller.Ch02Controller;

/*data와 관련이 있음*/
@Repository
public class Ch13BoardDao1 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13BoardDao1.class);
	
	public void select() {
		logger.info("게시물을 가져옵니다.");
	}
}
