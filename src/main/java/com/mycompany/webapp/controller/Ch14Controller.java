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

import com.mycompany.webapp.DAO.Ch14EmployeeDao;
import com.mycompany.webapp.dto.Ch14Employee;

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
		//connection pool에서 connection 대여
		try {
			Connection conn = dataSource.getConnection();
			logger.info("연결 성공");
			conn.close();
			//connection 반납
		} catch (SQLException e) {
			logger.info("연결 실패");
			e.printStackTrace();
		} finally {
			
		}
		return "ch14/content";
	}
	
	@Resource private Ch14EmployeeDao employeeDao;
	
	@GetMapping(value = "/employee")
	public String employee(int employee_id) {
		Ch14Employee emp = employeeDao.selectByPK(employee_id);
		logger.info("employee_id: " + emp.getEmployee_id());
		logger.info("first_name: " + emp.getFirst_name());
		logger.info("last_name: " + emp.getLast_name());
		System.out.println(emp.toString());
		return "ch14/content";
		
	}
	
}
