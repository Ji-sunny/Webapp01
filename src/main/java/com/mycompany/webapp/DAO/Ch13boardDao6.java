package com.mycompany.webapp.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("Ch13boardDao6Qualifier")
public class Ch13boardDao6 implements Ch13BoardDao{
	private static final Logger logger = LoggerFactory.getLogger(Ch13boardDao6.class);
	
	@Override
	public void insert() {
		logger.info("board실행");
		
	}

}
