package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.DAO.Ch14MemberDao;
import com.mycompany.webapp.dto.Ch14Member;

@Service
public class Ch14MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberService.class);
	
	
	@Resource
	private Ch14MemberDao memberDao;
	
	public void join(Ch14Member member) {
		memberDao.insert(member);
	}
	
	public String login(Ch14Member member) {
		//DB에서 가져온 데이터
		Ch14Member dbMember = memberDao.selectByPK(member.getMid());
		if(dbMember == null) {
			return "wrongMid";
		} else if (dbMember.getMpassword().equals(member.getMpassword())) {
			return "success";
		} else {
			return "wrongMpassword";
		}
	}

	public Ch14Member getMember(String mid) {
		Ch14Member member = memberDao.selectByPK(mid);
		return member;
	}
	
}
