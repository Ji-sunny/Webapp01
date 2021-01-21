package com.mycompany.webapp.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch14")
public class Ch14Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch14Controller.class);
	
	@GetMapping(value = "/content")
	public String Content() {
		return "ch14/content";
	}
	
	//root에 ch14_datasource가 있음 구현객체 있음
	@Resource
	private DataSource dataSource;
	
	@GetMapping(value = "/conntest")
	public String Conntest() {
		
		try {
			Connection conn = dataSource.getConnection();
			logger.info("연결 성공");
		} catch (SQLException e) {
			logger.info("연결 실패");
			e.printStackTrace();
		}
		return "ch14/content";
	}
	
}
