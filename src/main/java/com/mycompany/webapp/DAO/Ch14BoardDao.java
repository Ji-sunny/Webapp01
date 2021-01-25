package com.mycompany.webapp.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14board;

@Repository
public class Ch14BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14BoardDao.class);
	
	//Field datasource에서 가져오는거지
	@Resource
	private SqlSessionTemplate sst;
	
	//Method
	//return이 되는 게 자바 객체로 가져옴 그래서 field를 갖는 클래스가 return자리에 들어감
	public List<Ch14board> selectAll() {
		List<Ch14board> list = sst.selectList("mybatis.mapper.boards.selectAll");
		return list;
	}
	
	/* insert나 update ...등등에서 된 행수를 보여줌 */
	public int insert(Ch14board board) {
		int rows = sst.insert("mybatis.mapper.boards.insert", board);
		return rows;
	}
}
