package com.mycompany.webapp.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("Ch13boardDao5Qualifier")
public class Ch13boardDao5 implements Ch13BoardDao{
	private static final Logger logger = LoggerFactory.getLogger(Ch13boardDao5.class);
	
	@Override
	public void insert() {
		logger.info("실행");
	}

}
