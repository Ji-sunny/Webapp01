package com.mycompany.webapp.DAO;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Employee;

@Repository
public class Ch14EmployeeDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14EmployeeDao.class);
	
	//Field
	@Resource
	private SqlSessionTemplate sst;
	
	//Method
	//return이 되는 게 자바 객체로 가져옴 그래서 field를 갖는 클래스가 return자리에 들어감
	public Ch14Employee selectByPK(int employee_id) {
		Ch14Employee emp = sst.selectOne("mybatis.mapper.employees.selectByPK", employee_id);
		return emp;
	}
}
