package com.mycompany.webapp.DAO;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Member;

@Repository
public class Ch14MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberDao.class);
	
	//Field datasource에서 가져오는거지
	@Resource
	private SqlSessionTemplate sst;
	
	//Method
	//return이 되는 게 자바 객체로 가져옴 그래서 field를 갖는 클래스가 return자리에 들어감
	public Ch14Member selectByPK(String mid) {
		Ch14Member member = sst.selectOne("members.selectByPK", mid);
		return member;
	}

	public int insert(Ch14Member member) {
		int rows = sst.insert("members.insert", member);
		return rows;
	}
	
	
}
